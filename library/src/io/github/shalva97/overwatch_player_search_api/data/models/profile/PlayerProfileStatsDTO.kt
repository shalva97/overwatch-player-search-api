package io.github.shalva97.overwatch_player_search_api.data.models.profile

import io.github.shalva97.overwatch_player_search_api.data.models.compelte_profile.RatingDTO
import kotlinx.serialization.Serializable

@Serializable
internal data class PlayerProfileStatsDTO(
    val icon: String,
    val name: String,
    val endorsement: Int,
    val endorsementIcon: String,
    val title: String? = null,
    val namecardImage: String? = null,
    val ratings: List<RatingDTO>? = null,
    val private: Boolean,
    val quickPlayStats: QuickPlayStatsDTO,
    val competitiveStats: CompetitiveStatsDTO
)
