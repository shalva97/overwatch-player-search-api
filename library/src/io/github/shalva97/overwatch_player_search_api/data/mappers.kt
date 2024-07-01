package io.github.shalva97.overwatch_player_search_api.data

import io.github.shalva97.overwatch_player_search_api.data.models.profile.*
import io.github.shalva97.overwatch_player_search_api.data.models.search.OverwatchPlayerDTO
import io.github.shalva97.overwatch_player_search_api.domain.models.profile.*
import io.github.shalva97.overwatch_player_search_api.domain.models.search.OverwatchPlayer

internal fun OverwatchPlayerDTO.toDomain(
    namecard: String?,
    portrait: String?,
    title: String?
): OverwatchPlayer {
    return OverwatchPlayer(battleTag, frame, isPublic, lastUpdated, namecard, portrait, title, url)
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
    return CompetitiveStats(season, heroes, stats)
}

private fun QuickPlayStatsDTO.toDomainModel(): QuickPlayStats {
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
    return QuickPlayStats(heroes, stats)
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
