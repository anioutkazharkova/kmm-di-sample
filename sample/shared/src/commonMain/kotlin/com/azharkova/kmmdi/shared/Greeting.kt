package com.azharkova.kmmdi.shared

class Greeting {
    fun greeting(): String {
        return "Hello, ${com.azharkova.kmmdi.shared.Platform().platform}!"
    }
}
