package io.github.shalva97.overwatch_player_search_api

import com.fleeksoft.ksoup.Ksoup
import com.fleeksoft.ksoup.nodes.Document
import com.mohamedrejeb.ksoup.html.parser.KsoupHtmlHandler
import com.mohamedrejeb.ksoup.html.parser.KsoupHtmlParser
import kotlin.test.Test

class LearningTest {
    @Test
    fun exampleStats2() {
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
    fun exampleStats() {
        val handler = KsoupHtmlHandler
            .Builder()
            .onOpenTag(block = { name, attributes, isImplied ->
                println(name)
                println(attributes)
                println(isImplied)
            }).build()
        val ksoupHtmlParser = KsoupHtmlParser(handler)


// Pass the HTML to the parser (It is going to parse the HTML and call the callbacks)
        ksoupHtmlParser.write(someRandomGuy)


// Close the parser when you are done
        ksoupHtmlParser.end()
    }

    @Test
    fun blah() {
        val html = """
    <html>
        <head>
            <title>My Title</title>
        </head>
        <body>
            <h1>My Heading</h1>
            <p>My paragraph.</p>
        </body>
    </html>
""".trimIndent()

// String to store the extracted text
        var string = ""

// Create a handler
        val handler = KsoupHtmlHandler
            .Builder()
            .onText { text ->
                string += text
            }
            .build()

// Create a parser
        val ksoupHtmlParser = KsoupHtmlParser(
            handler = handler,
        )

// Pass the HTML to the parser (It is going to parse the HTML and call the callbacks)
        ksoupHtmlParser.write(html)

// Close the parser when you are done
        ksoupHtmlParser.end()

        println(string)
    }
}
