package io.github.shalva97.overwatch_player_search_api.domain.models

import kotlinx.serialization.Serializable

@Serializable
public data class OverwatchPlayer(
    val battleTag: String,
//    val frame: String,
    val isPublic: Boolean,
    val lastUpdated: Long,
    val namecard: String?,
    val portrait: String?,
    val title: String?,
    val url: String
)
