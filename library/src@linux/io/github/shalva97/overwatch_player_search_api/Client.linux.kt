package io.github.shalva97.overwatch_player_search_api

import io.ktor.client.HttpClient
import io.ktor.client.engine.ProxyConfig

public actual fun httpClient(
    proxy: ProxyConfig?,
    ignoreCertificateErrors: Boolean
): HttpClient {
    // Use Curl engine for Linux
    return HttpClient()
}
