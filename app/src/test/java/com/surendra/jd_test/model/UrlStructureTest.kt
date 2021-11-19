package com.surendra.jd_test.model

import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class UrlStructureTest : TestCase() {

    private lateinit var urlStructure: UrlStructure
    @Before
    fun setup(){
         urlStructure = UrlStructure(title= "title", isFeatured = true, isCampaign = true)
    }
    @Test
    fun testGetTitle() {
        assertEquals("title",urlStructure.title)
    }
    @Test
    fun testIsFeatured() {
        assert(urlStructure.isFeatured)

    }
    @Test
    fun testIsCampaign() {
        assert(urlStructure.isCampaign)

    }
}