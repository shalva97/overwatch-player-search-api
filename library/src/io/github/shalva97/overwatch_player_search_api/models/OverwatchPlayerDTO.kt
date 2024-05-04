package io.github.shalva97.overwatch_player_search_api.models

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

internal fun OverwatchPlayerDTO.toDomain(
    namecard: String?, portrait: String?, title: String?
): OverwatchPlayer {
    return OverwatchPlayer(battleTag, isPublic, lastUpdated, namecard, portrait, title, url)
}
