package io.github.shalva97.overwatch_player_search_api

import io.ktor.client.*
import io.ktor.client.engine.*

public expect fun httpClient(
    proxy: ProxyConfig? = null,
    ignoreCertificateErrors: Boolean = false
): HttpClient
