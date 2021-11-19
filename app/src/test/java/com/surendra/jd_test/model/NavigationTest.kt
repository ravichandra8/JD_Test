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
class NavigationTest : TestCase() {

    private lateinit var navigation: Navigation
    @Before
    fun setup(){
        val urlStructure = UrlStructure(title= "title", isFeatured = true, isCampaign = true)
         navigation = Navigation("http://www.jd.com","home","12345","1","1",urlStructure)
    }
    @Test
    fun testGetURI() {
        Assert.assertEquals("http://www.jd.com",navigation.uRI)
    }
    @Test
    fun testGetType() {
        Assert.assertEquals("home",navigation.type)

    }
    @Test
    fun testGetTarget() {
        Assert.assertEquals("12345",navigation.target)

    }
    @Test
    fun testGetDepth() {
        Assert.assertEquals("1",navigation.depth)

    }
    @Test
    fun testGetData() {
        Assert.assertEquals("1",navigation.data)

    }
    @Test
    fun testGetUrlStructure() {
        Assert.assertNotNull(navigation.urlStructure)
        Assert.assertEquals("title",navigation.urlStructure.title)

    }
}