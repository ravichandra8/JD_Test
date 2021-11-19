package com.surendra.jd_test.model

import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class NavDataTest : TestCase() {
    private lateinit var navData: NavData
    @Before
    fun setup(){
        val urlStructure = UrlStructure(title= "title", isFeatured = true, isCampaign = true)
        val navigation = Navigation("http://www.jd.com","home","12345","1","1",urlStructure)
        val stylesList =ArrayList<String>()
        stylesList.add("1")
        val childList = ArrayList<Child>()
         navData = NavData("home","Home","https://www.jd.com",navigation,stylesList,childList)
    }
    @Test
    fun testTestGetName() {
        Assert.assertEquals("home",navData.name)
    }
    @Test
    fun testGetNavigationName() {
        Assert.assertEquals("Home",navData.navigationName)

    }
    @Test
    fun testGetIcon() {
        Assert.assertEquals("https://www.jd.com",navData.icon)

    }
    @Test
    fun testGetNavigation() {
        Assert.assertNotNull(navData.navigation)
        Assert.assertEquals("home",navData.navigation.type)

    }
    @Test
    fun testGetStyles() {
        Assert.assertNotNull(navData.styles)
        Assert.assertEquals(1,navData.styles.size)
    }
    @Test
    fun testGetChildren() {
        Assert.assertNotNull(navData.children)
        Assert.assertEquals(0,navData.children?.size)
    }
}