package io.github.shalva97.overwatch_player_search_api

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*

public suspend fun main() {
    val client = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }
    println(
        client.get("https://overwatch.blizzard.com/en-us/search/account-by-name/shalva/")
            .body<List<OverwatchPlayerDTO>>()
    )

}
