package io.github.shalva97.overwatch_player_search_api.domain.models.complete_profile

public data class CompetitiveStats(
    val season: Int,
    val realSeason: Int,
    val timePlayed: String,
    val mostPlayedHero: String,
    val mostPlayedHeroTimePlayed: String,
)
