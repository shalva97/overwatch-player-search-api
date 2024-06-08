package io.github.shalva97.overwatch_player_search_api.data.models.profile

import kotlinx.serialization.Serializable

@Serializable
public data class CompetitiveStatsDTO(
    val season: Int,
    val topHeroes: TopHeroesDTO,
    val careerStats: CareerHeroesDTO
)
