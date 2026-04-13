package io.github.shalva97.overwatch_player_search_api.data.models.compelte_profile

import kotlinx.serialization.Serializable

@Serializable
public data class CompleteQuickPlayStatsDTO(
    val topHeroes: Map<String, TopHeroDTO>,
    val careerStats: Map<String, CareerHeroStatsDTO>
)
