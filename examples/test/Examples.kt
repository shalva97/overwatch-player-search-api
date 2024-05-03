import io.github.shalva97.overwatch_player_search_api.PlayerSearch
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class Examples {
    @Test
    fun searchPlayer() = runBlocking {
        val playerSearch = PlayerSearch()
        println(playerSearch.searchForPlayer("shalva"))
        playerSearch.close()
    }



}
