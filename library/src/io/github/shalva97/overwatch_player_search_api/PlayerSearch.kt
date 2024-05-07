package io.github.shalva97.overwatch_player_search_api

import io.github.shalva97.overwatch_player_search_api.models.OverwatchPlayer
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import io.github.shalva97.overwatch_player_search_api.models.OverwatchPlayerDTO
import io.github.shalva97.overwatch_player_search_api.models.toDomain
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

public class PlayerSearch {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

    private val owData by lazy {
        Json.parseToJsonElement(rawOwData)
    }

    public suspend fun searchForPlayer(name: String): List<OverwatchPlayer> {
        return client.get("https://overwatch.blizzard.com/en-us/search/account-by-name/$name/")
            .body<List<OverwatchPlayerDTO>>()
            .map {
                it.toDomain(
                    it.namecard?.let { it1 -> getNamecard(it1) },
                    it.portrait?.let { it1 -> getAvatar(it1) },
                    it.title?.let { it1 -> getTitle(it1) })
            }
    }

    public fun getAvatar(id: String): String? {
        return owData.jsonObject["avatars"]
            ?.jsonObject?.get(id)
            ?.jsonObject?.get("icon")
            ?.jsonPrimitive?.content
    }

    public fun getTitle(id: String): String? {
        return owData.jsonObject["titles"]
            ?.jsonObject?.get(id)
            ?.jsonObject?.get("name")
            ?.jsonObject?.get("en_US")
            ?.jsonPrimitive?.content
    }

    public fun getNamecard(id: String): String? {
        return owData.jsonObject["namecards"]
            ?.jsonObject?.get(id)
            ?.jsonObject?.get("icon")
            ?.jsonPrimitive?.content
    }

    private fun getPlayerProfile(url: String) {
        // TODO return  player profile
    }

    public fun close() {
        client.close()
    }
}

