package io.github.shalva97.overwatch_player_search_api.domain.models.profile

import kotlinx.serialization.json.JsonObject

public data class QuickPlayStats(val topHeroes: JsonObject, val careerStats: JsonObject)
