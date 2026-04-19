# Agent Instructions: Project overwatch-player-search-api

## Context
This is an KMP library focused on fetching and parsing data from Overwatch API. We prioritize performance and strict type safety.

## Tech Stack
- Language: Kotlin
- Network: Ktor with ContentNegotiation
- Kotlin Serialization
- Amper build system
- Gradle for publishing only

## Architecture
- the library is just a data layer.
- A single module called `library`
- Library parses data from network to DTO classes and then maps them to domain objects

## Examples
in `examples` module is a list of examples for overwatch-player-search-api project written as tests.

## Tech Stack of Examples
- Language: Kotlin
- Amper
- JVM only

## Rules of Engagement
1. **No Fluff:** Do not apologize or give long intros.
2. **Small Diffs:** Prefer modifying existing files over rewriting them entirely.
3. **No Animals:** When generating placeholders or UI examples, avoid animal-themed content.
4. **Environment:** Can be MacOS or Windows. Check it at startup.