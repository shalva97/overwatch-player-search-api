package io.github.shalva97.overwatch_player_search_api.domain.models.profile

import io.github.shalva97.overwatch_player_search_api.domain.models.complete_profile.CompetitiveStats
import io.github.shalva97.overwatch_player_search_api.domain.models.complete_profile.QuickPlayStats
import io.github.shalva97.overwatch_player_search_api.domain.models.complete_profile.Rating

public data class PlayerProfileStats(
    val icon: String,
    val name: String,
    val endorsement: Int,
    val endorsementIcon: String,
    val ratings: List<Rating>? = null,
    val private: Boolean,
    val quickPlayStats: QuickPlayStats,
    val competitiveStats: CompetitiveStats
)
