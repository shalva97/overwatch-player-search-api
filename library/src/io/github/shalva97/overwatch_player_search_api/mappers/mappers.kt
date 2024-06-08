package io.github.shalva97.overwatch_player_search_api.mappers

import io.github.shalva97.overwatch_player_search_api.models.profile.CareerHeroStats
import io.github.shalva97.overwatch_player_search_api.models.profile.TopHero
import io.github.shalva97.overwatch_player_search_api.parser.jsonParser
import kotlinx.serialization.json.JsonObject

public fun JsonObject.getTopHero(name: String): TopHero {
    return jsonParser.decodeFromString<TopHero>(get(name).toString())
}

public fun JsonObject.getCareerHeroStats(name: String): CareerHeroStats {
    return jsonParser.decodeFromString<CareerHeroStats>(get(name).toString())
}
