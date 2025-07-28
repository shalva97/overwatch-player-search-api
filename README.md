# Overwatch player search API

This library scrapes https://overwatch.blizzard.com/en-us/search/ and returns list of players. Works on Android and Desktop.

# Installation

Add and [authenticate](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-gradle-registry#using-a-published-package) via Github Package Repository

```kotlin
maven {
    url = uri("https://maven.pkg.github.com/shalva97/overwatch-player-search-api")
    credentials {
        username = System.getenv("USERNAME")
        password = System.getenv("TOKEN")
    }
}
```

Add dependency

```kotlin
implementation("io.github.shalva97.overwatch_player_search_api:library:2.0")
```

# Usage

Create an instance of `PlayerSearch` and use `searchForPlayer("username")`. This will return a list of `OverwatchPlayer`
data class, which will contain search results

```
[OverwatchPlayer(battleTag=username#1234, isPublic=true, lastUpdated=1715113111, namecard=https://d15f34w2p8l1cc.cloudfront.net/overwatch/7226589f015117e841d23356bc45835409c38ba8fb0d1451ca9268961fffde0f.png, portrait=null, title=Haunted Shadow, url=e156ad86a570d6ffb8a921a2%7C44a3944e9291875ca4bff9bad8d45767)]
```

Scraping player profile is done via https://owapi.eu API. Calling `.getPlayerProfile("username#1234")` will return player
statistics.

# Usage in Swift

This project supports SPM so just as with other packages this can be added via File -> Add package dependencies...

```swift
import Foundation
import OverwatchPlayerSearchApi

let service = PlayerSearch()
let dispatchGroup = DispatchGroup()

dispatchGroup.enter() // Indicate that an asynchronous task has started

service.searchForPlayer(name: "bigman", language: "en_US") { players, error -> () in
    for player in players! {
        print("name: \(player.battleTag) - title: \(player.title)")
    }
    dispatchGroup.leave() // Indicate that the asynchronous task has completed
}

// This will block the current thread until all tasks in the dispatchGroup have called `leave()`
// Use this with caution, especially on the main thread, as it can lead to UI freezes.
dispatchGroup.wait()
print("searchForPlayer has completed (using DispatchGroup.wait())")


```