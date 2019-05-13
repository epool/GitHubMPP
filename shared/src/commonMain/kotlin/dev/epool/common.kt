package dev.epool

import kotlin.coroutines.CoroutineContext

expect fun platformName(): String

class Greeting {

    fun greeting(): String = "Hello, ${platformName()}"

}

internal expect val applicationDispatcher: CoroutineContext