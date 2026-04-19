package io.github.shalva97.overwatch_player_search_api.data

import io.github.shalva97.overwatch_player_search_api.domain.models.profile.PlayerProfileStats
import io.github.shalva97.overwatch_player_search_api.data.models.compelte_profile.*
import io.github.shalva97.overwatch_player_search_api.data.models.profile.CompetitiveStatsDTO
import io.github.shalva97.overwatch_player_search_api.data.models.profile.PlayerProfileStatsDTO
import io.github.shalva97.overwatch_player_search_api.data.models.profile.QuickPlayStatsDTO
import io.github.shalva97.overwatch_player_search_api.data.models.search.OverwatchPlayerDTO
import io.github.shalva97.overwatch_player_search_api.domain.models.complete_profile.*
import io.github.shalva97.overwatch_player_search_api.domain.models.search.OverwatchPlayer

internal fun OverwatchPlayerDTO.toDomain(
    namecard: String?,
    portrait: String?,
    title: String?
): OverwatchPlayer {
    return OverwatchPlayer(isPublic, lastUpdated, namecard, portrait, title, url)
}

internal fun CompletePlayerProfileStatsDTO.toDomainModel(): CompletePlayerProfileStats {
    return CompletePlayerProfileStats(
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
        completeQuickPlayStats = quickPlayStats.toDomainModel(),
        completeCompetitiveStats = competitiveStats.toDomainModel()
    )
}

internal fun PlayerProfileStatsDTO.toDomainModel(): PlayerProfileStats {
    return PlayerProfileStats(
        icon = icon,
        name = name,
        endorsement = endorsement,
        endorsementIcon = endorsementIcon,
        ratings = ratings.toDomainModel(),
        private = private,
        quickPlayStats = quickplayStats.toDomainModel(),
        competitiveStats = competitiveStats.toDomainModel()
    )
}

private fun QuickPlayStatsDTO.toDomainModel(): QuickPlayStats {
    return QuickPlayStats(
        gamesPlayed = gamesPlayed,
        gamesWon = gamesWon,
        gamesLost = gamesLost,
        timePlayed = timePlayed,
        mostPlayedHero = mostPlayedHero,
        mostPlayedHeroTimePlayed = mostPlayedHeroTimePlayed,
        mostPlayedHeroGamesPlayed = mostPlayedHeroGamesPlayed,
        mostPlayedHeroWinPercentage = mostPlayedHeroWinPercentage
    )
}

private fun CompetitiveStatsDTO.toDomainModel(): CompetitiveStats {
    return CompetitiveStats(
        season = season,
        realSeason = realSeason,
        timePlayed = timePlayed,
        mostPlayedHero = mostPlayedHero,
        mostPlayedHeroTimePlayed = mostPlayedHeroTimePlayed,
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

private fun CompleteCompetitiveStatsDTO.toDomainModel(): CompleteCompetitiveStats {
    val heroes =
        topHeroes.entries
            .map { (name, topHero) ->
                TopHero(
                    name = name,
                    timePlayed = topHero.timePlayed,
                    gamesWon = topHero.gamesWon,
                    weaponAccuracy = topHero.weaponAccuracy,
                    criticalHitAccuracy = topHero.criticalHitAccuracy,
                    eliminationsPerLife = topHero.eliminationsPerLife,
                    multiKillBest = topHero.multiKillBest,
                    objectiveKills = topHero.objectiveKills
                )
            }
    val stats =
        careerStats.entries
            .map { (heroName, careerHero) ->
                CareerHeroStats(
                    name = heroName,
                    assists = careerHero.assists?.toDomainModel(),
                    average = careerHero.average?.toDomainModel(),
                    best = careerHero.best?.toDomainModel(),
                    combat = careerHero.combat?.toDomainModel(),
                    heroSpecific = careerHero.heroSpecific,
                    game = careerHero.game.toDomainModel(),
                    matchAwards = careerHero.matchAwards
                )
            }
    return CompleteCompetitiveStats(season, heroes, stats)
}

private fun CompleteQuickPlayStatsDTO.toDomainModel(): CompleteQuickPlayStats {
    val heroes =
        topHeroes.entries
            .map { (name, topHero) ->
                TopHero(
                    name = name,
                    timePlayed = topHero.timePlayed,
                    gamesWon = topHero.gamesWon,
                    weaponAccuracy = topHero.weaponAccuracy,
                    criticalHitAccuracy = topHero.criticalHitAccuracy,
                    eliminationsPerLife = topHero.eliminationsPerLife,
                    multiKillBest = topHero.multiKillBest,
                    objectiveKills = topHero.objectiveKills
                )
            }
    val stats =
        careerStats.entries
            .map { (heroName, careerHero) ->
                CareerHeroStats(
                    name = heroName,
                    assists = careerHero.assists?.toDomainModel(),
                    average = careerHero.average?.toDomainModel(),
                    best = careerHero.best?.toDomainModel(),
                    combat = careerHero.combat?.toDomainModel(),
                    heroSpecific = careerHero.heroSpecific,
                    game = careerHero.game.toDomainModel(),
                    matchAwards = careerHero.matchAwards
                )
            }
    return CompleteQuickPlayStats(heroes, stats)
}

private fun CombatDTO.toDomainModel(): Combat {
    return Combat(
        damageDone = damageDone,
        deaths = deaths,
        eliminations = eliminations,
        environmentalKills = environmentalKills,
        finalBlows = finalBlows,
        heroDamageDone = heroDamageDone,
        meleeFinalBlows = meleeFinalBlows,
        multikills = multikills,
        objectiveContestTime = objectiveContestTime,
        objectiveKills = objectiveKills,
        objectiveTime = objectiveTime,
        soloKills = soloKills,
        timeSpentOnFire = timeSpentOnFire
    )
}

private fun GameDTO.toDomainModel(): Game {
    return Game(gamesLost, gamesPlayed, gamesWon, heroWins, timePlayed)
}

private fun BestDTO.toDomainModel(): Best {
    return Best(
        allDamageDoneMostInGame = allDamageDoneMostInGame,
        assistsMostInGame = assistsMostInGame,
        barrierDamageDoneMostInGame = barrierDamageDoneMostInGame,
        defensiveAssistsMostInGame = defensiveAssistsMostInGame,
        eliminationsMostInGame = eliminationsMostInGame,
        environmentalKillsMostInGame = environmentalKillsMostInGame,
        finalBlowsMostInGame = finalBlowsMostInGame,
        healingDoneMostInGame = healingDoneMostInGame,
        heroDamageDoneMostInGame = heroDamageDoneMostInGame,
        killsStreakBest = killsStreakBest,
        meleeFinalBlowsMostInGame = meleeFinalBlowsMostInGame,
        multikillsBest = multikillsBest,
        objectiveContestTimeMostInGame = objectiveContestTimeMostInGame,
        objectiveKillsMostInGame = objectiveKillsMostInGame,
        objectiveTimeMostInGame = objectiveTimeMostInGame,
        offensiveAssistsMostInGame = offensiveAssistsMostInGame,
        reconAssistsMostInGame = reconAssistsMostInGame,
        soloKillsMostInGame = soloKillsMostInGame,
        timeSpentOnFireMostInGame = timeSpentOnFireMostInGame
    )
}

private fun AverageDTO.toDomainModel(): Average {
    return Average(
        assistsAvgPer10Min = assistsAvgPer10Min,
        deathsAvgPer10Min = deathsAvgPer10Min,
        eliminationsAvgPer10Min = eliminationsAvgPer10Min,
        finalBlowsAvgPer10Min = finalBlowsAvgPer10Min,
        healingDoneAvgPer10Min = healingDoneAvgPer10Min,
        heroDamageDoneAvgPer10Min = heroDamageDoneAvgPer10Min,
        objectiveContestTimeAvgPer10Min = objectiveContestTimeAvgPer10Min,
        objectiveKillsAvgPer10Min = objectiveKillsAvgPer10Min,
        objectiveTimeAvgPer10Min = objectiveTimeAvgPer10Min,
        soloKillsAvgPer10Min = soloKillsAvgPer10Min,
        timeSpentOnFireAvgPer10Min = timeSpentOnFireAvgPer10Min
    )
}

private fun AssistsDTO.toDomainModel(): Assists {
    return Assists(assists, defensiveAssists, healingDone, offensiveAssists, reconAssists)
}
