package io.github.shalva97.overwatch_player_search_api.models.profile

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
public data class CareerHeroStats(
    val assists: Assists? = null,
    val average: Average,
    val best: Best,
    val combat: Combat,
    val heroSpecific: JsonElement?,
    val game: Game,
    val matchAwards: JsonElement?
)
