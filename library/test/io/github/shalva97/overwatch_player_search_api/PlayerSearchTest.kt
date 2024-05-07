package io.github.shalva97.overwatch_player_search_api

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
}
