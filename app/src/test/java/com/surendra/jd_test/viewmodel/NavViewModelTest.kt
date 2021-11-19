package com.surendra.jd_test.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.surendra.jd_test.model.*
import com.surendra.jd_test.repository.JDRepository
import com.surendra.jd_test.utils.TestCoroutineRule
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response
import kotlin.collections.ArrayList
import androidx.lifecycle.Observer
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.mockito.Mockito.verify


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class NavViewModelTest : TestCase() {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var jdRepository: JDRepository

    private lateinit var navViewModel:NavViewModel


    @Mock
    private lateinit var navResponseObserver: Observer<RootResponse>

    @Before
    fun setup() {

        navViewModel = NavViewModel(jdRepository)
        navViewModel.responseNavData.observeForever(navResponseObserver)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testGetResponseNavData() = runBlocking {


        val urlStructure = UrlStructure(title = "title", isFeatured = true, isCampaign = true)
        val navigation = Navigation("http://www.jd.com", "home", "12345", "1", "1", urlStructure)
        val stylesList = ArrayList<String>()
        stylesList.add("1")
        val childList = ArrayList<Child>()
        val navData =
            NavData("home", "Home", "https://www.jd.com", navigation, stylesList, childList)
        val navDataList = ArrayList<NavData>()
        navDataList.add(navData)
        val res = Response.success(RootResponse(navDataList))

        Mockito.doReturn(res)
            .`when`(jdRepository)
            .getNavData()

        navViewModel.getAllImages()

        verify(navResponseObserver).onChanged(res.body())
    }

}