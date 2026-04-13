package io.github.shalva97.overwatch_player_search_api.domain.models.complete_profile


public data class CompleteCompetitiveStats(
    val season: Int,
    val topHeroes: List<TopHero>,
    val careerStats: List<CareerHeroStats>
)
