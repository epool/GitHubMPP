package dev.epool.githubkmp

import android.app.Application
import dev.epool.api.GithubApi
import dev.epool.model.MembersDataRepository
import dev.epool.presentation.DataRepository

class GitHubKMPApplication : Application() {

    val dataRepository: DataRepository by lazy {
        MembersDataRepository(GithubApi())
    }

}