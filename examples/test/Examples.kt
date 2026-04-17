import io.github.shalva97.overwatch_player_search_api.PlayerSearch
import io.github.shalva97.overwatch_player_search_api.httpClient
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class Examples {
    @Test
    fun searchPlayer() = runBlocking {
        val search = PlayerSearch()
        val res = search.searchForPlayer("khinkali")
        println(res)
    }

    @Test
    fun searchPlayer2() = runBlocking {
        val search = PlayerSearch()
        val res = search.searchForPlayer("bigman")
        println(res)
    }

    @Test
    fun getCompletePlayerProfile(): Unit = runBlocking {
        val search = PlayerSearch()
        val res = search.getCompletePlayerProfileForPC("Senna#11894")
        println(res)
    }

    @Test
    fun getConsoleStats() = runBlocking {
        val search = PlayerSearch()
        val res = search.getCompletePlayerProfileForConsole("bigman#31423")
        println(res)
    }

    @Test
    fun showHeroStatistics_getTopHero() = runBlocking {
        val search = PlayerSearch()
        val res = search.getCompletePlayerProfileForPC("shalva#21962")
        res.completeQuickPlayStats.topHeroes.take(3).println()
    }

    @Test
    fun showHeroStatistics_getCareerHeroStats() = runBlocking {
        val search = PlayerSearch()
        val res = search.getCompletePlayerProfileForPC("shalva#21962")
        res.completeQuickPlayStats.careerStats.take(3).println()
    }

    @Test
    fun showHeroStatistics_getTopHeroes() = runBlocking {
        val search = PlayerSearch()
        val res = search.getCompletePlayerProfileForPC("shalva#21962")
        res.completeCompetitiveStats.careerStats.take(3).println()
    }

    @Test
    fun getPlayerProfile(): Unit = runBlocking {
        val search = PlayerSearch(client = httpClient())
        val res = search.getPlayerProfileForPC("Senna#11894")
        println(res)
    }
}

fun Any.println() {
    println(this)
}
