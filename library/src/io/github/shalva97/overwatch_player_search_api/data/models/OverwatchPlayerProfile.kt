package io.github.shalva97.overwatch_player_search_api.data.models

import io.github.shalva97.overwatch_player_search_api.domain.models.Category

public data class Hero(val name: String, val stats: List<Category>)

public data class Category(val name: String, val rows: List<Pair<String, String>>)
