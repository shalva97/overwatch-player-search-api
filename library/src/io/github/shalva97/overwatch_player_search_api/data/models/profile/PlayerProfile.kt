package io.github.shalva97.overwatch_player_search_api.data.models.profile

import io.github.shalva97.overwatch_player_search_api.domain.models.profile.CompetitiveStats
import io.github.shalva97.overwatch_player_search_api.domain.models.profile.QuickPlayStats
import io.github.shalva97.overwatch_player_search_api.domain.models.profile.Rating
import kotlinx.serialization.Serializable

@Serializable
public data class PlayerProfileStatsDTO(
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
    val quickPlayStats: QuickPlayStatsDTO,
    val competitiveStats: CompetitiveStatsDTO
)
