package io.github.shalva97.overwatch_player_search_api.data.models.profile

import io.github.shalva97.overwatch_player_search_api.domain.models.profile.Average
import io.github.shalva97.overwatch_player_search_api.domain.models.profile.Best
import io.github.shalva97.overwatch_player_search_api.domain.models.profile.Combat
import io.github.shalva97.overwatch_player_search_api.domain.models.profile.Game
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
public data class CareerHeroStatsDTO(
    val assists: AssistsDTO? = null,
    val average: AverageDTO? = null,
    val best: BestDTO? = null,
    val combat: CombatDTO? = null,
    val heroSpecific: JsonElement?,
    val game: GameDTO,
    val matchAwards: JsonElement?
)
