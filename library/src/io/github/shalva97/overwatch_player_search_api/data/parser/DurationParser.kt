package io.github.shalva97.overwatch_player_search_api.data.parser

import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

internal fun timePlayedParserToDuration(durationString: String): Duration {
    val parts = durationString.split(":")
    if (parts.size != 3) {
        throw IllegalArgumentException("Invalid duration format, expected HH:mm:ss")
    }

    val hours = parts[0].toLong()
    val minutes = parts[1].toLong()
    val seconds = parts[2].toLong()

    val totalSeconds = hours * 3600 + minutes * 60 + seconds

    return totalSeconds.seconds
}

