package io.github.shalva97.overwatch_player_search_api.models

data class Hero(val name: String, val stats: List<Category>)

data class Category(val name: String, val rows: List<Pair<String, String>>)
