package io.github.shalva97.overwatch_player_search_api.data.models.compelte_profile

import kotlinx.serialization.Serializable

@Serializable
public data class CompletePlayerProfileStatsDTO(
    val icon: String,
    val name: String,
    val endorsement: Int,
    val endorsementIcon: String,
    val title: String,
    val ratings: List<RatingDTO>? = null,
    val gamesWon: Int,
    val gamesLost: Int,
    val gamesPlayed: Int,
    val private: Boolean,
    val quickPlayStats: CompleteQuickPlayStatsDTO,
    val competitiveStats: CompleteCompetitiveStatsDTO
)
