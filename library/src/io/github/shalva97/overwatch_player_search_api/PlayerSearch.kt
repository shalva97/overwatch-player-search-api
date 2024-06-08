package io.github.shalva97.overwatch_player_search_api

import io.github.shalva97.overwatch_player_search_api.data.OWDataRepo
import io.github.shalva97.overwatch_player_search_api.data.models.search.OverwatchPlayerDTO
import io.github.shalva97.overwatch_player_search_api.data.models.profile.PlayerProfileStatsDTO
import io.github.shalva97.overwatch_player_search_api.data.parser.jsonParser
import io.github.shalva97.overwatch_player_search_api.data.toDomain
import io.github.shalva97.overwatch_player_search_api.data.toDomainModel
import io.github.shalva97.overwatch_player_search_api.domain.models.search.OverwatchPlayer
import io.github.shalva97.overwatch_player_search_api.domain.models.profile.PlayerProfileStats
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*

public class PlayerSearch {

    private val client = HttpClient { install(ContentNegotiation) { json(jsonParser) } }
    private val owRepo = OWDataRepo()

    public suspend fun searchForPlayer(
        name: String,
        language: String = "en_US"
    ): List<OverwatchPlayer> {
        return client
            .get("https://overwatch.blizzard.com/en-us/search/account-by-name/$name/")
            .body<List<OverwatchPlayerDTO>>()
            .map {
                it.toDomain(
                    it.namecard?.let { it1 -> owRepo.getNamecard(it1) },
                    it.portrait?.let { it1 -> owRepo.getAvatar(it1) },
                    it.title?.let { it1 -> owRepo.getTitle(it1, language) })
            }
    }

    public suspend fun getPlayerProfileForPC(playerTag: String): PlayerProfileStats {
        val tagForOwapi = playerTag.replace('#', '-')

        return client
            .get("https://owapi.eu/stats/pc/$tagForOwapi/complete")
            .body<PlayerProfileStatsDTO>()
            .toDomainModel()
    }

    public suspend fun getPlayerProfileForConsole(playerTag: String): PlayerProfileStats {
        val tagForOwapi = playerTag.replace('#', '-')

        return client
            .get("https://owapi.eu/stats/console/$tagForOwapi/complete")
            .body<PlayerProfileStatsDTO>()
            .toDomainModel()
    }

    public fun close() {
        client.close()
    }
}
