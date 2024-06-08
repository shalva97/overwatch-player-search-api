package io.github.shalva97.overwatch_player_search_api.domain.models.profile

import kotlinx.serialization.Serializable

public data class Assists(
    val assists: Int? = null,
    val defensiveAssists: Int? = null,
    val healingDone: Int? = null,
    val offensiveAssists: Int? = null,
    val reconAssists: Int? = null
)
