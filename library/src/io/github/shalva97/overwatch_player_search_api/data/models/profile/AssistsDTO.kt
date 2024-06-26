package io.github.shalva97.overwatch_player_search_api.data.models.profile

import kotlinx.serialization.Serializable

@Serializable
public data class AssistsDTO(
    val assists: Int? = null,
    val defensiveAssists: Int? = null,
    val healingDone: Int? = null,
    val offensiveAssists: Int? = null,
    val reconAssists: Int? = null
)
