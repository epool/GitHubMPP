package dev.epool.api

import dev.epool.model.Member
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.Url
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import kotlinx.serialization.list

class GithubApi {

    private val client = HttpClient()

    private val membersUrl = Url("https://api.github.com/orgs/JetBrains/members")

    @UnstableDefault
    suspend fun getMembers(): List<Member> = client.get<String> {
        url(membersUrl.toString())
    }.let {
        Json.parse(Member.serializer().list, it)
    }

}