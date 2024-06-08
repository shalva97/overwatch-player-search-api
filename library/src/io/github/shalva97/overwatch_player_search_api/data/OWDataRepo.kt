package io.github.shalva97.overwatch_player_search_api.data

import io.github.shalva97.overwatch_player_search_api.ow_data.avatars
import io.github.shalva97.overwatch_player_search_api.ow_data.namecards
import io.github.shalva97.overwatch_player_search_api.ow_data.titles
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

internal class OWDataRepo {
    private val owAvatars by lazy { Json.parseToJsonElement(avatars) }

    private val owNamecards by lazy { Json.parseToJsonElement(namecards) }

    private val owTitles by lazy { Json.parseToJsonElement(titles) }

    fun getAvatar(id: String): String? {
        return owAvatars.jsonObject[id]?.jsonObject?.get("icon")?.jsonPrimitive?.content
    }

    fun getTitle(id: String, language: String): String? {
        return owTitles.jsonObject[id]
            ?.jsonObject
            ?.get("name")
            ?.jsonObject
            ?.get(language)
            ?.jsonPrimitive
            ?.content
    }

    fun getNamecard(id: String): String? {
        return owNamecards.jsonObject[id]?.jsonObject?.get("icon")?.jsonPrimitive?.content
    }
}
