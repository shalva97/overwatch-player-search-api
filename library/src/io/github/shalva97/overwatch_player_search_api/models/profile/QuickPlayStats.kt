package io.github.shalva97.overwatch_player_search_api.models.profile

import kotlinx.serialization.Serializable

@Serializable
public data class QuickPlayStats(
    val topHeroes: TopHeroes,
    val careerStats: CareerHeroes
)
