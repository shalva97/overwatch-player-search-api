import io.github.shalva97.overwatch_player_search_api.PlayerSearch
import io.github.shalva97.overwatch_player_search_api.httpClient
import io.ktor.client.engine.ProxyConfig
import io.ktor.network.sockets.InetSocketAddress
import kotlinx.coroutines.runBlocking
import java.net.Proxy
import kotlin.test.Test

class Examples {

    val proxy = Proxy(Proxy.Type.HTTP, java.net.InetSocketAddress("localhost", 9000))
    val search = PlayerSearch(
        client = httpClient(
            proxy = proxy,
            ignoreCertificateErrors = true
        )
    )

    @Test
    fun searchPlayer() = runBlocking {
        val res = search.searchForPlayer("khinkali")
        println(res)
    }

    @Test
    fun searchPlayer2() = runBlocking {
        val res = search.searchForPlayer("bigman")
        println(res)
    }

    @Test
    fun getCompletePlayerProfile(): Unit = runBlocking {
        val res = search.getCompletePlayerProfileForPC("Senna#11894")
        println(res)
    }

    @Test
    fun getConsoleStats() = runBlocking {
        val res = search.getCompletePlayerProfileForConsole("bigman#31423")
        println(res)
    }

    @Test
    fun showHeroStatistics_getTopHero() = runBlocking {
        val res = search.getCompletePlayerProfileForPC("shalva#21962")
        res.completeQuickPlayStats.topHeroes.take(3).println()
    }

    @Test
    fun showHeroStatistics_getCareerHeroStats() = runBlocking {
        val res = search.getCompletePlayerProfileForPC("shalva#21962")
        res.completeQuickPlayStats.careerStats.take(3).println()
    }

    @Test
    fun showHeroStatistics_getTopHeroes() = runBlocking {
        val res = search.getCompletePlayerProfileForPC("shalva#21962")
        res.completeCompetitiveStats.careerStats.take(3).println()
    }

    @Test
    fun getPlayerProfile(): Unit = runBlocking {
        val res = search.getPlayerProfileForPC("Senna#11894")
        println(res)
    }
}

fun Any.println() {
    println(this)
}
