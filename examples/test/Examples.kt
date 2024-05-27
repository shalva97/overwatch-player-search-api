import io.github.shalva97.overwatch_player_search_api.PlayerSearch
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class Examples {
    @Test
    fun searchPlayer() = runBlocking {
        val search = PlayerSearch()
        val res = search.searchForPlayer("shalva")
        println(res)
    }

    @Test
    fun searchPlayer2() = runBlocking {
        val search = PlayerSearch()
        val res = search.searchForPlayer("bigman")
        println(res)
    }

    @Test
    fun getPlayerProfile(): Unit = runBlocking {
        val search = PlayerSearch()
        val message = search.getPlayerProfileForPC("shalva#21962")
        println(message)
    }

    @Test
    fun getConsoleStats() = runBlocking {
        val search = PlayerSearch()
        val message = search.getPlayerProfileForConsole("bigman#31423")
        println(message)
    }
}
