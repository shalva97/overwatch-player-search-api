package io.github.shalva97.overwatch_player_search_api.data.parser

import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


public fun HttpClientConfig<*>.installJsonParser() {
    install(ContentNegotiation) { json(jsonParser) }
}

internal val jsonParser = Json {
    ignoreUnknownKeys = true
    isLenient = true
}
