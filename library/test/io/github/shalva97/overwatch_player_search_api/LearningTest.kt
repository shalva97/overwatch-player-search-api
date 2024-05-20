package io.github.shalva97.overwatch_player_search_api

import com.fleeksoft.ksoup.Ksoup
import com.fleeksoft.ksoup.nodes.Document
import io.github.shalva97.overwatch_player_search_api.models.profile.PlayerProfileStats
import io.github.shalva97.overwatch_player_search_api.sample_data.randomPlayerJSON
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.io.buffered
import kotlinx.io.files.Path
import kotlinx.io.files.SystemFileSystem
import kotlinx.io.readLine
import kotlinx.io.readString
import kotlinx.serialization.json.Json
import okio.Path.Companion.toPath
import kotlin.test.Test

public class LearningTest {
    private val jsonParser = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    @Test
    public fun exampleStats2() {
        val html = "<html><head><title>One</title></head><body>Two</body></html>"
        val doc: Document =
            Ksoup.parse(html = io.github.shalva97.overwatch_player_search_api.sample_data.someRandomGuy)
        val firstOption = doc.select(".mouseKeyboard-view.Profile-view")[0]
            .select(".stats.quickPlay-view")[0]
            .select(".stats-container.option-0")[0]
            .select(".category")[0]
        val categoryName = firstOption.select(".content")[0].firstElementChild()?.text()
        val res = firstOption.select(".content")[0].children().drop(1).map {
            it.select(".name")[0].text() to it.select(".value")[0].text()
        }
        println(res)
    }

    @Test
    public fun exampleStats() {
        println(jsonParser.decodeFromString<PlayerProfileStats>(randomPlayerJSON))
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    public fun blah() {

        val currentOWData = Path("./player-search.html")
        println(SystemFileSystem.sink(Path("./src/io/github/shalva97/overwatch_player_search_api/rawOWData.kt")))
//        println(SystemFileSystem.sink(Path("./io/github/shalva97/overwatch_player_search_api/rawOWData.kt")))
    }
}
