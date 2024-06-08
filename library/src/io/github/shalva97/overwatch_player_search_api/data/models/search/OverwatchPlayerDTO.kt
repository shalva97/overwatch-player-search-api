package io.github.shalva97.overwatch_player_search_api.data.models.search

import kotlinx.serialization.Serializable

@Serializable
internal data class OverwatchPlayerDTO(
    val battleTag: String,
    val frame: String?,
    val isPublic: Boolean,
    val lastUpdated: Long,
    val namecard: String? = null,
    val portrait: String? = null,
    val title: String? = null,
    val url: String
)
