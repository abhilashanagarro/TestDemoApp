package com.example.testapplication

import org.junit.Assert
import org.junit.Test

class LoginTest {

    @Test
    fun testWithCorrectValues(){
        val email = "abhi@gmail.com"
        val password = "Abhi@1234"
        val responseOfExecutingYourApiWithCorrectValues = true
        Assert.assertEquals(true,responseOfExecutingYourApiWithCorrectValues)
    }

    @Test
    fun testWithEmptyValues(){
        val email = ""
        val password = ""
        val responseOfExecutingYourApiWithCorrectValues = false
        Assert.assertEquals(false,responseOfExecutingYourApiWithCorrectValues)
    }

    @Test
    fun testWithInvalidEmailValues(){
        val email = "abhi@co.in"
        val password = "Abhi@1234"
        val responseOfExecutingYourApiWithCorrectValues = false
        Assert.assertEquals(false,responseOfExecutingYourApiWithCorrectValues)
    }

    @Test
    fun testWithInvalidPasswordValues(){
        val email = "Abhi@gmail.com"
        val password = "abhi@1234"
        val responseOfExecutingYourApiWithCorrectValues = false
        Assert.assertEquals(false,responseOfExecutingYourApiWithCorrectValues)
    }
}