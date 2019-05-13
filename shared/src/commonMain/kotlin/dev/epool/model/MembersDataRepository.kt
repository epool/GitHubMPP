package dev.epool.model

import dev.epool.api.GithubApi
import dev.epool.api.UpdateProblem
import dev.epool.presentation.DataRepository
import kotlinx.serialization.UnstableDefault

class MembersDataRepository(private val api: GithubApi) : DataRepository {

    override var members: List<Member>? = null

    override var onRefreshListeners: List<() -> Unit> = emptyList()

    @UnstableDefault
    override suspend fun update() {
        val newMembers = try {
            api.getMembers()
        } catch (cause: Throwable) {
            throw UpdateProblem(cause)
        }
        if (members != newMembers) {
            members = newMembers
            callRefreshListeners()
        }
    }

    private fun callRefreshListeners() {
        onRefreshListeners.forEach { it() }
    }

}