package io.github.shalva97.overwatch_player_search_api.domain.models.profile

import io.github.shalva97.overwatch_player_search_api.domain.models.profile.CareerHeroStats
import kotlinx.serialization.Serializable


public data class CareerHeroes(
    val allHeroes: CareerHeroStats? = null,
    val ana: CareerHeroStats? = null,
    val ashe: CareerHeroStats? = null,
    val baptiste: CareerHeroStats? = null,
    val bastion: CareerHeroStats? = null,
    val brigitte: CareerHeroStats? = null,
    val cassidy: CareerHeroStats? = null,
    val dVa: CareerHeroStats? = null,
    val doomfist: CareerHeroStats? = null,
    val echo: CareerHeroStats? = null,
    val genji: CareerHeroStats? = null,
    val hanzo: CareerHeroStats? = null,
    val illari: CareerHeroStats? = null,
    val junkerQueen: CareerHeroStats? = null,
    val junkrat: CareerHeroStats? = null,
    val kiriko: CareerHeroStats? = null,
    val lifeweaver: CareerHeroStats? = null,
    val lucio: CareerHeroStats? = null,
    val mauga: CareerHeroStats? = null,
    val mei: CareerHeroStats? = null,
    val mercy: CareerHeroStats? = null,
    val moira: CareerHeroStats? = null,
    val orisa: CareerHeroStats? = null,
    val ramattra: CareerHeroStats? = null,
    val reaper: CareerHeroStats? = null,
    val reinhardt: CareerHeroStats? = null,
    val roadhog: CareerHeroStats? = null,
    val sigma: CareerHeroStats? = null,
    val soldier76: CareerHeroStats? = null,
    val sombra: CareerHeroStats? = null,
    val torbjorn: CareerHeroStats? = null,
    val tracer: CareerHeroStats? = null,
    val widowmaker: CareerHeroStats? = null,
    val winston: CareerHeroStats? = null,
    val wreckingBall: CareerHeroStats? = null,
    val zarya: CareerHeroStats? = null,
    val zenyatta: CareerHeroStats? = null,
)