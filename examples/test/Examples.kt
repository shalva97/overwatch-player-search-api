import io.github.shalva97.overwatch_player_search_api.PlayerSearch
import io.github.shalva97.overwatch_player_search_api.mappers.getCareerHeroStats
import io.github.shalva97.overwatch_player_search_api.mappers.getTopHero
import io.github.shalva97.overwatch_player_search_api.models.profile.TopHero
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
        val res = search.getPlayerProfileForPC("shalva#21962")
        println(res)
    }

    @Test
    fun getConsoleStats() = runBlocking {
        val search = PlayerSearch()
        val res = search.getPlayerProfileForConsole("bigman#31423")
        println(res)
    }

    @Test
    fun showHeroStatistics_getTopHero() = runBlocking {
        val search = PlayerSearch()
        val res = search.getPlayerProfileForPC("shalva#21962")
        res.quickPlayStats.topHeroes.getTopHero("ana").println()
    }

    @Test
    fun showHeroStatistics_getCareerHeroStats() = runBlocking {
        val search = PlayerSearch()
        val res = search.getPlayerProfileForPC("shalva#21962")
        res.quickPlayStats.careerStats.getCareerHeroStats("ana").println()
    }

    @Test
    fun showHeroStatistics_getTopHeroes() = runBlocking {
        val search = PlayerSearch()
        val res = search.getPlayerProfileForPC("shalva#21962")
        res.quickPlayStats.topHeroes.forEach {
//            println(it.key + it.value) // TODO
        }
    }
}

fun Any.println() {
    println(this)
}
