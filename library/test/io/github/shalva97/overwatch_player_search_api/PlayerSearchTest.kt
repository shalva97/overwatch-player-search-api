package io.github.shalva97.overwatch_player_search_api

import io.github.shalva97.overwatch_player_search_api.data.OWDataRepo
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.runBlocking
import kotlinx.io.buffered
import kotlinx.io.bytestring.encodeToByteString
import kotlinx.io.files.Path
import kotlinx.io.files.SystemFileSystem
import kotlinx.io.readString
import kotlinx.io.write
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

public class PlayerSearchTest {

    @Test
    public fun getTitle() {
        val search = OWDataRepo()

        assertEquals("Haunted Shadow", search.getTitle("0x0250000000006B2E", "en_US"))
    }

    @Test
    public fun getNamecard() {
        val search = OWDataRepo()

        assertEquals(
            "https://d15f34w2p8l1cc.cloudfront.net/overwatch/7226589f015117e841d23356bc45835409c38ba8fb0d1451ca9268961fffde0f.png",
            search.getNamecard("0x0250000000006A8D")
        )
    }

    @Test
    public fun getIcon() {
        val search = OWDataRepo()

        assertEquals(
            "https://d15f34w2p8l1cc.cloudfront.net/overwatch/d3e03d1b5b0b85f3cf98847cfd0a396a311a370363c46245e254ce2e3a040527.png",
            search.getAvatar("0x0250000000004B0E")
        )
    }

    @Test
    public fun OWDataIsUpToDate(): Unit = runBlocking {
        val client = HttpClient()

        val owData =
            client
                .get("https://overwatch.blizzard.com/en-us/search/")
                .bodyAsText()
                .lines()
                .filterOWDataLines()
        val currentOWData =
            SystemFileSystem.source(Path("./player-search.html"))
                .buffered()
                .readString()
                .lines()
                .filterOWDataLines()
        assertEquals(owData, currentOWData)
    }

    @Test
    @Ignore // only run this manually
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
        response
            .bodyAsText()
            .lines()
            .filterOWDataLines()
            .map {
                it.removePrefix("const avatars =")
                    .removePrefix("const namecards =")
                    .removePrefix("const titles =")
            }
            .zip(listOf("avatars", "namecards", "titles"))
            .forEach {
                it.second + it.first
                val content = createFileContents(it.second, it.first)
                writeTextToFile(it.second, content)
            }
    }
}

private fun List<String>.filterOWDataLines(): List<String> {
    return filter {
        it.contains("const avatars") ||
            it.contains("const namecards") ||
            it.contains("const titles")
    }
}

private fun createFileContents(variableName: String, variableContent: String): String {
    return """package io.github.shalva97.overwatch_player_search_api

        internal val $variableName = """ +
        "\"\"\"" +
        variableContent +
        "\"\"\""
}

private fun writeTextToFile(name: String, content: String) {
    val sink =
        SystemFileSystem.sink(Path("./src/io/github/shalva97/overwatch_player_search_api/$name.kt"))
    sink.buffered().write(content.encodeToByteString())
    sink.flush()
}
