package io.github.shalva97.overwatch_player_search_api.data.models.profile

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
public data class QuickPlayStatsDTO(val topHeroes: TopHeroesDTO, val careerStats: CareerHeroesDTO)
