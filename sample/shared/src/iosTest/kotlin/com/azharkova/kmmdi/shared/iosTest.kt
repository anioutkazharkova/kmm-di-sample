package com.azharkova.kmmdi.shared

import kotlin.test.Test
import kotlin.test.assertTrue

class IosGreetingTest {

    @Test
    fun testExample() {
        assertTrue(com.azharkova.kmmdi.shared.Greeting().greeting().contains("iOS"), "Check iOS is mentioned")
    }
}
