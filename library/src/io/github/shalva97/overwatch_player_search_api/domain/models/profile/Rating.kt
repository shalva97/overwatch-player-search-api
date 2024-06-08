package io.github.shalva97.overwatch_player_search_api.domain.models.profile

import kotlinx.serialization.Serializable


public data class Rating(
    val group: String,
    val tier: Int,
    val role: String,
    val roleIcon: String,
    val rankIcon: String,
    val tierIcon: String
)
