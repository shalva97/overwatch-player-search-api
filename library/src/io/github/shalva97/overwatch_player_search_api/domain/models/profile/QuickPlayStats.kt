package io.github.shalva97.overwatch_player_search_api.domain.models.profile

public data class QuickPlayStats(
    val topHeroes: List<TopHero>,
    val careerStats: List<CareerHeroStats>
)
