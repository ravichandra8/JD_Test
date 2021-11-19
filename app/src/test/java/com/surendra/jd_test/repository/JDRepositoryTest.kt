package com.surendra.jd_test.repository

import com.surendra.jd_test.model.*
import com.surendra.jd_test.utils.TestCoroutineRule
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class JDRepositoryTest : TestCase(){

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var jdDataService: JDDataService

    private lateinit var jdRepository: JDRepository

    @Before
    fun setup(){
        jdRepository = JDRepository(jdDataService)
    }


    @Test
    fun testGetNavData(){
        testCoroutineRule.runBlockingTest {
            val urlStructure = UrlStructure(title= "title", isFeatured = true, isCampaign = true)
            val navigation = Navigation("http://www.jd.com","home","12345","1","1",urlStructure)
            val stylesList =ArrayList<String>()
            stylesList.add("1")
            val childList = ArrayList<Child>()
            val navData = NavData("home","Home","https://www.jd.com",navigation,stylesList,childList)
            val navDataList = ArrayList<NavData>()
            navDataList.add(navData)
            val rootResponse = RootResponse(navDataList)

            doReturn(rootResponse)
                .`when`(jdDataService)
                .getNavData()

            Assert.assertEquals(rootResponse, jdRepository.getNavData())

        }
    }
}