package io.github.shalva97.overwatch_player_search_api.data.models.profile

import kotlinx.serialization.Serializable

@Serializable
public data class AverageDTO(
    val assistsAvgPer10Min: Float? = null,
    val deathsAvgPer10Min: Float? = null,
    val eliminationsAvgPer10Min: Float? = null,
    val finalBlowsAvgPer10Min: Float? = null,
    val healingDoneAvgPer10Min: Float? = null,
    val heroDamageDoneAvgPer10Min: Float? = null,
    val objectiveContestTimeAvgPer10Min: String? = null,
    val objectiveKillsAvgPer10Min: Float? = null,
    val objectiveTimeAvgPer10Min: String? = null,
    val soloKillsAvgPer10Min: Float? = null,
    val timeSpentOnFireAvgPer10Min: String? = null
)
