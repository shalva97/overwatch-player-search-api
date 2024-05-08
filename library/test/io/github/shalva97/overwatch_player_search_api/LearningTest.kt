package io.github.shalva97.overwatch_player_search_api

import com.fleeksoft.ksoup.Ksoup
import com.fleeksoft.ksoup.nodes.Document
import com.mohamedrejeb.ksoup.html.parser.KsoupHtmlHandler
import com.mohamedrejeb.ksoup.html.parser.KsoupHtmlParser
import kotlin.test.Test

public class LearningTest {
    @Test
    public fun exampleStats2() {
        val html = "<html><head><title>One</title></head><body>Two</body></html>"
        val doc: Document = Ksoup.parse(html = someRandomGuy)
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

    }
}
