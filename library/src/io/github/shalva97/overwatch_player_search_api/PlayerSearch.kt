package io.github.shalva97.overwatch_player_search_api

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import io.github.shalva97.overwatch_player_search_api.models.OverwatchPlayerDTO

class PlayerSearch {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

    suspend fun searchForPlayer(name: String): List<OverwatchPlayerDTO> {
        return client.get("https://overwatch.blizzard.com/en-us/search/account-by-name/$name/")
            .body<List<OverwatchPlayerDTO>>()
    }

    fun close() {
        client.close()
    }
}

