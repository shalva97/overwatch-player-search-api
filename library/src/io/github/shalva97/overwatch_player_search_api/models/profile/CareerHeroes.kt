package io.github.shalva97.overwatch_player_search_api.models.profile

import kotlinx.serialization.Serializable

@Serializable
public data class CareerHeroes(
    val allHeroes: CareerHeroStats,
    val ana: CareerHeroStats,
    val ashe: CareerHeroStats,
    val baptiste: CareerHeroStats,
    val bastion: CareerHeroStats,
    val brigitte: CareerHeroStats,
    val cassidy: CareerHeroStats,
    val dVa: CareerHeroStats,
    val doomfist: CareerHeroStats,
    val echo: CareerHeroStats,
    val genji: CareerHeroStats,
    val hanzo: CareerHeroStats,
    val illari: CareerHeroStats,
    val junkerQueen: CareerHeroStats,
    val junkrat: CareerHeroStats,
    val kiriko: CareerHeroStats,
    val lifeweaver: CareerHeroStats,
    val lucio: CareerHeroStats,
    val mauga: CareerHeroStats,
    val mei: CareerHeroStats,
    val mercy: CareerHeroStats,
    val moira: CareerHeroStats,
    val orisa: CareerHeroStats,
    val ramattra: CareerHeroStats,
    val reaper: CareerHeroStats,
    val reinhardt: CareerHeroStats,
    val roadhog: CareerHeroStats,
    val sigma: CareerHeroStats,
    val soldier76: CareerHeroStats,
    val sombra: CareerHeroStats,
    val torbjorn: CareerHeroStats,
    val tracer: CareerHeroStats,
    val widowmaker: CareerHeroStats,
    val winston: CareerHeroStats,
    val wreckingBall: CareerHeroStats,
    val zarya: CareerHeroStats,
    val zenyatta: CareerHeroStats
)
