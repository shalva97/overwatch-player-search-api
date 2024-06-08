package io.github.shalva97.overwatch_player_search_api.data.models.profile

import io.github.shalva97.overwatch_player_search_api.domain.models.profile.TopHero
import kotlinx.serialization.Serializable

@Serializable
public data class TopHeroesDTO(
    val ana: TopHeroDTO? = null,
    val ashe: TopHeroDTO? = null,
    val baptiste: TopHeroDTO? = null,
    val bastion: TopHeroDTO? = null,
    val brigitte: TopHeroDTO? = null,
    val cassidy: TopHeroDTO? = null,
    val dVa: TopHeroDTO? = null,
    val doomfist: TopHeroDTO? = null,
    val echo: TopHeroDTO? = null,
    val genji: TopHeroDTO? = null,
    val hanzo: TopHeroDTO? = null,
    val illari: TopHeroDTO? = null,
    val junkerQueen: TopHeroDTO? = null,
    val junkrat: TopHeroDTO? = null,
    val kiriko: TopHeroDTO? = null,
    val lifeweaver: TopHeroDTO? = null,
    val lucio: TopHeroDTO? = null,
    val mauga: TopHeroDTO? = null,
    val mei: TopHeroDTO? = null,
    val mercy: TopHeroDTO? = null,
    val moira: TopHeroDTO? = null,
    val orisa: TopHeroDTO? = null,
    val ramattra: TopHeroDTO? = null,
    val reaper: TopHeroDTO? = null,
    val reinhardt: TopHeroDTO? = null,
    val roadhog: TopHeroDTO? = null,
    val sigma: TopHeroDTO? = null,
    val soldier76: TopHeroDTO? = null,
    val sombra: TopHeroDTO? = null,
    val torbjorn: TopHeroDTO? = null,
    val tracer: TopHeroDTO? = null,
    val widowmaker: TopHeroDTO? = null,
    val winston: TopHeroDTO? = null,
    val wreckingBall: TopHeroDTO? = null,
    val zarya: TopHeroDTO? = null,
    val zenyatta: TopHeroDTO? = null,
)
