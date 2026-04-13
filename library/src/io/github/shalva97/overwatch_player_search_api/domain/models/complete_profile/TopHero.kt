package io.github.shalva97.overwatch_player_search_api.domain.models.complete_profile

import io.github.shalva97.overwatch_player_search_api.data.parser.timePlayedParserToDuration
import kotlin.time.Duration

public data class TopHero(
    val name: String,
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
