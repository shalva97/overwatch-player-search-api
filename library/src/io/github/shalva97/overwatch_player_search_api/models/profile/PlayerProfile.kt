package io.github.shalva97.overwatch_player_search_api.models.profile

import kotlinx.serialization.Serializable


@Serializable
public data class PlayerProfileStats(
    val icon: String,
    val name: String,
    val endorsement: Int,
    val endorsementIcon: String,
    val title: String,
    val ratings: List<Rating>,
    val gamesWon: Int,
    val gamesLost: Int,
    val private: Boolean,
    // TODO add quickPlayStats and competitiveStats
)

@Serializable
public data class Rating(
    val group: String,
    val tier: Int,
    val role: String,
    val roleIcon: String,
    val rankIcon: String,
    val tierIcon: String
)
