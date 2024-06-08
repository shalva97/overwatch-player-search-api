package io.github.shalva97.overwatch_player_search_api.parser

import kotlinx.serialization.json.Json

internal val jsonParser = Json {
    ignoreUnknownKeys = true
    isLenient = true
}
