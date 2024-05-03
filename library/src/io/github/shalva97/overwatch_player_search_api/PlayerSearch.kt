package io.github.shalva97.overwatch_player_search_api

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import io.github.shalva97.overwatch_player_search_api.models.OverwatchPlayerDTO
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

class PlayerSearch {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

    private val owData by lazy {
        Json.parseToJsonElement(rawOwData)
    }

    suspend fun searchForPlayer(name: String): List<OverwatchPlayerDTO> {
        return client.get("https://overwatch.blizzard.com/en-us/search/account-by-name/$name/")
            .body<List<OverwatchPlayerDTO>>()
    }

    fun getAvatar(id: String): String? {
        return owData.jsonObject["avatars"]
            ?.jsonObject?.get(id)
            ?.jsonObject?.get("icon")
            ?.jsonPrimitive?.content
    }

    fun getTitle(id: String): String? {
        return owData.jsonObject["titles"]
            ?.jsonObject?.get(id)
            ?.jsonObject?.get("name")
            ?.jsonObject?.get("en_US")
            ?.jsonPrimitive?.content
    }

    fun getNamecard(id: String): String? {
        return owData.jsonObject["namecards"]
            ?.jsonObject?.get(id)
            ?.jsonObject?.get("icon")
            ?.jsonPrimitive?.content
    }

    fun close() {
        client.close()
    }
}

