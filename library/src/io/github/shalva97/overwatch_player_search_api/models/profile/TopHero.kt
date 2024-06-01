package io.github.shalva97.overwatch_player_search_api.models.profile

import io.github.shalva97.overwatch_player_search_api.parser.timePlayedParserToDuration
import kotlinx.serialization.Serializable
import kotlin.time.Duration

@Serializable
public data class TopHero(
    val timePlayed: String,
    val gamesWon: Int,
    val weaponAccuracy: Float,
    val criticalHitAccuracy: Float,
    val eliminationsPerLife: Float,
    val multiKillBest: Int,
    val objectiveKills: Int,
) {
    val timePlayedDuration: Duration by lazy {
        timePlayedParserToDuration(timePlayed)
    }
}
