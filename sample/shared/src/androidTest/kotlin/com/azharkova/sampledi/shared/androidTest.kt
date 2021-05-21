package com.azharkova.sampledi.shared

import org.junit.Assert.assertTrue
import org.junit.Test

class AndroidGreetingTest {

    @Test
    fun testExample() {
        assertTrue("Check Android is mentioned", com.azharkova.kmmdi.shared.Greeting().greeting().contains("Android"))
    }
}
