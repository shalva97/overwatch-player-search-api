package io.github.shalva97.overwatch_player_search_api.data.models.profile

import kotlinx.serialization.Serializable

@Serializable
public data class GameDTO(
    val gamesLost: Int? = null,
    val gamesPlayed: Int? = null,
    val gamesWon: Int? = null,
    val heroWins: Int? = null,
    val timePlayed: String
)
