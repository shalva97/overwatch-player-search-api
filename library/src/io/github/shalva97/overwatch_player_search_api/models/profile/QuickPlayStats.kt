package io.github.shalva97.overwatch_player_search_api.models.profile

import io.github.shalva97.overwatch_player_search_api.parser.jsonParser
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
public data class QuickPlayStats(val topHeroes: JsonObject, val careerStats: JsonObject)
