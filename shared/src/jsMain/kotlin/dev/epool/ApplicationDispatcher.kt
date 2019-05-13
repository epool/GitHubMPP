package dev.epool

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

internal actual val applicationDispatcher: CoroutineContext = Dispatchers.Main