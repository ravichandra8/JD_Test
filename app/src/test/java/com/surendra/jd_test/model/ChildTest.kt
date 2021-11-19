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
class ChildTest : TestCase() {

    private lateinit var child: Child
    @Before
    fun setup(){
        child = Child("home","Home")
    }
    @Test
    fun testTestGetName() {
        Assert.assertEquals("home",child.name)
    }
    @Test
    fun testGetNavigationName() {
        Assert.assertEquals("Home",child.navigationName)
    }
}