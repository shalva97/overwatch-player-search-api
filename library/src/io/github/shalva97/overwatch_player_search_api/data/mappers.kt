package io.github.shalva97.overwatch_player_search_api.data

import io.github.shalva97.overwatch_player_search_api.data.models.OverwatchPlayerDTO
import io.github.shalva97.overwatch_player_search_api.data.models.profile.CompetitiveStatsDTO
import io.github.shalva97.overwatch_player_search_api.data.models.profile.PlayerProfileStatsDTO
import io.github.shalva97.overwatch_player_search_api.data.models.profile.QuickPlayStatsDTO
import io.github.shalva97.overwatch_player_search_api.data.models.profile.RatingDTO
import io.github.shalva97.overwatch_player_search_api.domain.models.OverwatchPlayer
import io.github.shalva97.overwatch_player_search_api.domain.models.profile.CompetitiveStats
import io.github.shalva97.overwatch_player_search_api.domain.models.profile.PlayerProfileStats
import io.github.shalva97.overwatch_player_search_api.domain.models.profile.QuickPlayStats
import io.github.shalva97.overwatch_player_search_api.domain.models.profile.Rating

internal fun OverwatchPlayerDTO.toDomain(
    namecard: String?,
    portrait: String?,
    title: String?
): OverwatchPlayer {
    return OverwatchPlayer(battleTag, isPublic, lastUpdated, namecard, portrait, title, url)
}

internal fun PlayerProfileStatsDTO.toDomainModel(): PlayerProfileStats {
    return PlayerProfileStats(
        icon = icon,
        name = name,
        endorsement = endorsement,
        endorsementIcon = endorsementIcon,
        title = title,
        ratings = ratings.toDomainModel(),
        gamesWon = gamesWon,
        gamesLost = gamesLost,
        gamesPlayed = gamesPlayed,
        private = private,
        quickPlayStats = quickPlayStats.toDomainModel(),
        competitiveStats = competitiveStats.toDomainModel()
    )
}

private fun List<RatingDTO>?.toDomainModel(): List<Rating>? {
    return this?.map {
        Rating(
            group = it.group,
            tier = it.tier,
            role = it.role,
            roleIcon = it.roleIcon,
            rankIcon = it.rankIcon,
            tierIcon = it.tierIcon
        )
    }
}

private fun CompetitiveStatsDTO.toDomainModel(): CompetitiveStats {
    return CompetitiveStats(season, topHeroes, careerStats)
}

private fun QuickPlayStatsDTO.toDomainModel(): QuickPlayStats {
    return QuickPlayStats(topHeroes, careerStats)
}
