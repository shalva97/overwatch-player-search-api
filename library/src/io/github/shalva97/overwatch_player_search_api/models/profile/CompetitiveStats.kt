package io.github.shalva97.overwatch_player_search_api.models.profile

import kotlinx.serialization.Serializable

@Serializable
public data class CompetitiveStats(
    val season: Int,
    val topHeroes: TopHeroes,
    val careerStats: CareerHeroes
)
