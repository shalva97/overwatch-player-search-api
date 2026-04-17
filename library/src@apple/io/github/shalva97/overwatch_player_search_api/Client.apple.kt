package io.github.shalva97.overwatch_player_search_api

import io.ktor.client.HttpClient
import io.ktor.client.engine.ProxyConfig
import io.ktor.client.engine.darwin.Darwin

public actual fun httpClient(
    proxy: ProxyConfig?,
    ignoreCertificateErrors: Boolean
): HttpClient {
    // Use Darwin engine for Apple platforms
    return HttpClient(Darwin) {
        proxy?.let { engine {
            this.proxy = it
        } }
        // Ignoring certificate errors is not implemented for simplicity
    }
}
