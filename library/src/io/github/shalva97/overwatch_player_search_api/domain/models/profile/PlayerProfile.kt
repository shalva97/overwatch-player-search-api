package io.github.shalva97.overwatch_player_search_api.domain.models.profile

public data class PlayerProfileStats(
    val icon: String,
    val name: String,
    val endorsement: Int,
    val endorsementIcon: String,
    val title: String,
    val ratings: List<Rating>? = null,
    val gamesWon: Int,
    val gamesLost: Int,
    val gamesPlayed: Int,
    val private: Boolean,
    val quickPlayStats: QuickPlayStats,
    val competitiveStats: CompetitiveStats
)
