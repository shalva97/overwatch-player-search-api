package io.github.shalva97.overwatch_player_search_api.domain.models.profile

public data class Game(
    val gamesLost: Int? = null,
    val gamesPlayed: Int? = null,
    val gamesWon: Int? = null,
    val heroWins: Int? = null,
    val timePlayed: String
)
