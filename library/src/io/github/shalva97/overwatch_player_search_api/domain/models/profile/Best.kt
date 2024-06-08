package io.github.shalva97.overwatch_player_search_api.domain.models.profile

import kotlinx.serialization.Serializable

public data class Best(
    val allDamageDoneMostInGame: Int? = null,
    val assistsMostInGame: Int? = null,
    val barrierDamageDoneMostInGame: Int? = null,
    val defensiveAssistsMostInGame: Int? = null,
    val eliminationsMostInGame: Int? = null,
    val environmentalKillsMostInGame: Int? = null,
    val finalBlowsMostInGame: Int? = null,
    val healingDoneMostInGame: Int? = null,
    val heroDamageDoneMostInGame: Int? = null,
    val killsStreakBest: Int? = null,
    val meleeFinalBlowsMostInGame: Int? = null,
    val multikillsBest: Int? = null,
    val objectiveContestTimeMostInGame: String? = null,
    val objectiveKillsMostInGame: Int? = null,
    val objectiveTimeMostInGame: String? = null,
    val offensiveAssistsMostInGame: Int? = null,
    val reconAssistsMostInGame: Int? = null,
    val soloKillsMostInGame: Int? = null,
    val timeSpentOnFireMostInGame: String? = null
)
