package io.github.shalva97.overwatch_player_search_api.domain.models.complete_profile

public data class CompleteQuickPlayStats(
    val topHeroes: List<TopHero>,
    val careerStats: List<CareerHeroStats>
)
