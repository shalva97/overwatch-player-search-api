# Overwatch player search API

This library scrapes https://overwatch.blizzard.com/en-us/search/ and returns list of players

# Installation

Add and authenticate via Github Package Repository

```kotlin
maven {
    url = uri("https://maven.pkg.github.com/shalva97/overwatch-player-search-api")
    credentials {
        val properties = Properties().apply {
            runCatching { load(FileInputStream("local.properties")) }
                .onFailure {
                    println("Failed to load properties. You need to authenticate with Github Packages to download all dependencies")
                }
        }
        username = properties["gpr.user"] as String? ?: System.getenv("USERNAME")
        password = properties["gpr.key"] as String? ?: System.getenv("TOKEN")
    }
}
```

Add dependency

```kotlin
implementation("io.github.shalva97.overwatch_player_search_api:library:1.3")
```

# Usage

Create an instance of `PlayerSearch` and use `searchForPlayer("username")`. This will return a list of `OverwatchPlayer`
data class, which will contain search results

```
[OverwatchPlayer(battleTag=shalva#21966, isPublic=true, lastUpdated=1715113111, namecard=https://d15f34w2p8l1cc.cloudfront.net/overwatch/7226589f015117e841d23356bc45835409c38ba8fb0d1451ca9268961fffde0f.png, portrait=null, title=Haunted Shadow, url=e156ad86a570d6ffb8a921a2%7C44a3944e9291875ca4bff9bad8d45767)]
```

Scraping player profile is done via https://owapi.eu API. Calling `.getPlayerProfile("shalva#1234")` will return player
statistics.
