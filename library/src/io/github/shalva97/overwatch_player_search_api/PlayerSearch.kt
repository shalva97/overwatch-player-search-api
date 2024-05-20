package io.github.shalva97.overwatch_player_search_api

import io.github.shalva97.overwatch_player_search_api.models.OverwatchPlayer
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import io.github.shalva97.overwatch_player_search_api.models.OverwatchPlayerDTO
import io.github.shalva97.overwatch_player_search_api.models.profile.PlayerProfileStats
import io.github.shalva97.overwatch_player_search_api.models.toDomain
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

public class PlayerSearch {
    private val jsonParser = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(jsonParser)
        }
    }

    private val owAvatars by lazy {
        Json.parseToJsonElement("avatars") // TODO load text fom resources
    }

    private val owNamecards by lazy {
        Json.parseToJsonElement("namecards")
    }

    private val owTitles by lazy {
        Json.parseToJsonElement("titles")
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

    public suspend fun getPlayerProfile(playerTag: String): PlayerProfileStats {
        val tagForOwapi = playerTag.replace('#', '-')

        return client.get("https://owapi.eu/stats/pc/$tagForOwapi/complete")
            .body<PlayerProfileStats>()
    }

    public fun getAvatar(id: String): String? {
        return owAvatars
            ?.jsonObject?.get(id)
            ?.jsonObject?.get("icon")
            ?.jsonPrimitive?.content
    }

    public fun getTitle(id: String): String? {
        return owTitles
            ?.jsonObject?.get(id)
            ?.jsonObject?.get("name")
            ?.jsonObject?.get("en_US")
            ?.jsonPrimitive?.content
    }

    public fun getNamecard(id: String): String? {
        return owNamecards
            ?.jsonObject?.get(id)
            ?.jsonObject?.get("icon")
            ?.jsonPrimitive?.content
    }

    public fun close() {
        client.close()
    }
}

