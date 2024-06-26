package io.github.shalva97.overwatch_player_search_api.domain.models.profile

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject


public data class CompetitiveStats(
    val season: Int,
    val topHeroes: List<TopHero>,
    val careerStats: List<CareerHeroStats>
)
