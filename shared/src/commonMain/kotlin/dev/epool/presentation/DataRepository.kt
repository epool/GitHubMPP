package dev.epool.presentation

import dev.epool.model.Member

interface DataRepository {

    var members: List<Member>?
    var onRefreshListeners: List<() -> Unit>

    suspend fun update()

}