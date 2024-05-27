package io.github.shalva97.overwatch_player_search_api.models.profile

import kotlinx.serialization.Serializable

@Serializable
public data class Game(
    val gamesLost: Int,
    val gamesPlayed: Int,
    val gamesWon: Int? = null,
    val heroWins: Int? = null,
    val timePlayed: String
)