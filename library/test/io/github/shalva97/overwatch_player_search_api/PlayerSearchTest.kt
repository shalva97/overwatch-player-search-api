package io.github.shalva97.overwatch_player_search_api

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.util.*
import io.ktor.utils.io.core.*
import kotlinx.coroutines.runBlocking
import kotlinx.io.*
import kotlinx.io.files.Path
import kotlinx.io.files.SystemFileSystem
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

public class PlayerSearchTest {

    @Test
    public fun getTitle() {
        val search = PlayerSearch()

        assertEquals("Haunted Shadow", search.getTitle("0x0250000000006B2E"))
    }

    @Test
    public fun getNamecard() {
        val search = PlayerSearch()

        assertEquals(
            "https://d15f34w2p8l1cc.cloudfront.net/overwatch/7226589f015117e841d23356bc45835409c38ba8fb0d1451ca9268961fffde0f.png",
            search.getNamecard("0x0250000000006A8D")
        )
    }

    @Test
    public fun getIcon() {
        val search = PlayerSearch()

        assertEquals(
            "https://d15f34w2p8l1cc.cloudfront.net/overwatch/d3e03d1b5b0b85f3cf98847cfd0a396a311a370363c46245e254ce2e3a040527.png",
            search.getAvatar("0x0250000000004B0E")
        )
    }

    @Test
    public fun OWDataIsUpToDate(): Unit = runBlocking {
        val client = HttpClient()

        val owData = client.get("https://overwatch.blizzard.com/en-us/search/").bodyAsText().lines()
            .filterOWDataLines()
        val currentOWData =
            SystemFileSystem.source(Path("./player-search.html")).buffered().readString().lines()
                .filterOWDataLines()
        assertEquals(owData, currentOWData)
    }

    @OptIn(InternalAPI::class, ExperimentalStdlibApi::class)
    @Test
//    @Ignore // only run this manually
    public fun updateLocalOWData(): Unit = runBlocking {
        val client = HttpClient()
        val response = client.get("https://overwatch.blizzard.com/en-us/search/")
        // save response to a file, so later it is possible to check if the website has changes
//        val playerSearchFile = SystemFileSystem.sink(Path("./player-search.html"))
//        playerSearchFile.buffered().write(response.toByteArray())
//        playerSearchFile.close()

        // save it to a file, so it can be read in Kotlin
        // first line will be avatars, second - namecards and last - titles
//
        val data =
            "package io.github.shalva97.overwatch_player_search_api\n" + response.bodyAsText()
                .lines().filterOWDataLines().map {
                    it.removePrefix("const avatars =").removePrefix("const namecards =")
                        .removePrefix("const titles =")
                }.zip(
                    listOf(
                        "internal val avatars = ",
                        "internal val namecards = ",
                        "internal val titles = "
                    )
                ).map {
                    it.second + it.first
                }.joinToString("\n")
        SystemFileSystem.sink(Path("./src/io/github/shalva97/overwatch_player_search_api/rawOWData.kt"))
            .buffered().write(data.toByteArray())
    }
}


private fun List<String>.filterOWDataLines(): List<String> {
    return filter { it.contains("const avatars") || it.contains("const namecards") || it.contains("const titles") }
}
