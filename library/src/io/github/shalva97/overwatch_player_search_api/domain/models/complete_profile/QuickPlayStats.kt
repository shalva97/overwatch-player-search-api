package io.github.shalva97.overwatch_player_search_api.domain.models.complete_profile

public data class QuickPlayStats(
    val gamesPlayed: Int,
    val gamesWon: Int,
    val gamesLost: Int,
    val timePlayed: String,
    val mostPlayedHero: String,
    val mostPlayedHeroTimePlayed: String,
    val mostPlayedHeroGamesPlayed: Int,
    val mostPlayedHeroWinPercentage: Int
)
