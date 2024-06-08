package io.github.shalva97.overwatch_player_search_api.domain.models.profile

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

public data class CareerHeroStats(
    val name: String,
    val assists: Assists? = null,
    val average: Average? = null,
    val best: Best? = null,
    val combat: Combat? = null,
    val heroSpecific: JsonElement?,
    val game: Game,
    val matchAwards: JsonElement?
)
