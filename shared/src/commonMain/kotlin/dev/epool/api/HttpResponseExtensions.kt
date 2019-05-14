package dev.epool.api

import io.ktor.client.response.HttpResponse
import io.ktor.client.response.readText
import io.ktor.http.Url
import io.ktor.http.isSuccess
import kotlinx.io.IOException
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json

internal fun HttpResponse.nextPage(): Int = headers["Link"]?.let { linkHeader ->
    val regex = """.*<(.*?)>; rel="next".*""".toRegex()
    if (regex.matches(linkHeader)) {
        val url = Url(regex.find(linkHeader)!!.groupValues[1])
        url.parameters["page"]?.toInt()
    } else null
} ?: -1

@UnstableDefault
internal suspend fun <T> HttpResponse.get(deserializer: DeserializationStrategy<T>): T =
    with(readText()) {
        if (status.isSuccess()) {
            Json.parse(deserializer, this)
        } else {
            throw IOException("Status Code: $status, Body: $this")
        }
    }