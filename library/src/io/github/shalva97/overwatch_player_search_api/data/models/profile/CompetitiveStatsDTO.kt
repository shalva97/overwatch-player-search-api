package io.github.shalva97.overwatch_player_search_api.data.models.profile

import kotlinx.serialization.Serializable

@Serializable
internal data class CompetitiveStatsDTO(
    val season: Int,
    val realSeason: Int,
    val timePlayed: String,
    val mostPlayedHero: String,
    val mostPlayedHeroTimePlayed: String,
)
