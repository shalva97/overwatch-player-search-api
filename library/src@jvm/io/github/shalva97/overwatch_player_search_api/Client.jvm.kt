package io.github.shalva97.overwatch_player_search_api

import io.github.shalva97.overwatch_player_search_api.data.parser.installJsonParser
import io.github.shalva97.overwatch_player_search_api.data.parser.jsonParser
import io.ktor.client.HttpClient
import io.ktor.client.engine.ProxyConfig
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

public actual fun httpClient(
    proxy: ProxyConfig?,
    ignoreCertificateErrors: Boolean
): HttpClient {
    return HttpClient(OkHttp) {
        proxy?.let {
            engine {
                this.proxy = it
            }
        }
        installJsonParser()
        // Ignoring certificate errors is not implemented for simplicity
    }
}
