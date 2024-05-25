package io.github.shalva97.overwatch_player_search_api.models.profile

import kotlinx.serialization.Serializable

@Serializable
public data class TopHero(
    val timePlayed: String,
    val gamesWon: Int,
    val weaponAccuracy: Float,
    val criticalHitAccuracy: Float,
    val eliminationsPerLife: Float,
    val multiKillBest: Int,
    val objectiveKills: Int,
)
