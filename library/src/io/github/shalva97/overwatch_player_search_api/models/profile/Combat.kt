package io.github.shalva97.overwatch_player_search_api.models.profile

import kotlinx.serialization.Serializable

@Serializable
public data class Combat(
    val damageDone: Int? = null,
    val deaths: Int? = null,
    val eliminations: Int? = null,
    val environmentalKills: Int? = null,
    val finalBlows: Int? = null,
    val heroDamageDone: Int? = null,
    val meleeFinalBlows: Int? = null,
    val multikills: Int? = null,
    val objectiveContestTime: String? = null,
    val objectiveKills: Int? = null,
    val objectiveTime: String? = null,
    val soloKills: Int? = null,
    val timeSpentOnFire: String? = null
)
