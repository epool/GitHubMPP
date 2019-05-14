package dev.epool.api

import dev.epool.model.Member
import dev.epool.serializables.MembersList
import io.ktor.client.HttpClient
import io.ktor.client.call.call
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.features.logging.SIMPLE
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.http.HttpMethod
import io.ktor.http.URLProtocol
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.list

class GithubApi {

    private val client = HttpClient {
        defaultRequest {
            url {
                protocol = URLProtocol.HTTPS
                host = "api.github.com"
            }
            method = HttpMethod.Get
            header("Authorization", "token 2c152a5f3db23d79010989c821318e04300ac1e8")
        }
        install(Logging) {
            logger = Logger.SIMPLE
            level = LogLevel.ALL
        }
        install(JsonFeature) {
            serializer = KotlinxSerializer().apply {
                setMapper(MembersList::class, MembersList.serializer())
            }
        }
    }

    private val membersUrl = "/orgs/JetBrains/members"

    @UnstableDefault
    suspend fun getMembers(perPage: Int = 30): List<Member> {
        val members = mutableListOf<Member>()
        var page = 1
        do {
            val response = client.call {
                url { encodedPath = membersUrl }
                parameter("page", page)
                parameter("per_page", perPage)
            }.response
            members.addAll(response.get(Member.serializer().list))
            page = response.nextPage()
        } while (page > 0)
        return members
    }

}