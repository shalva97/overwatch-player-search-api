package io.github.shalva97.overwatch_player_search_api

import io.ktor.client.HttpClient
import io.ktor.client.engine.ProxyConfig
import io.ktor.client.engine.cio.CIO

public actual fun httpClient(
    proxy: ProxyConfig?,
    ignoreCertificateErrors: Boolean
): HttpClient {
    // Use CIO engine for Windows (mingw)
    return HttpClient(CIO) {
        proxy?.let { engine {
            this.proxy = it
        } }
        // Ignoring certificate errors is not implemented for simplicity
    }
}
