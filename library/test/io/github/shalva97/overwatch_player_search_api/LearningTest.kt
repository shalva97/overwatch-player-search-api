package io.github.shalva97.overwatch_player_search_api

import io.github.shalva97.overwatch_player_search_api.data.parser.timePlayedParserToDuration
import kotlinx.serialization.json.Json
import kotlin.test.Test

public class LearningTest {
    private val jsonParser = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    @Test
    public fun parseTime() {
        val rawTime = "128:36:08"

        println(timePlayedParserToDuration(rawTime))
    }
}

