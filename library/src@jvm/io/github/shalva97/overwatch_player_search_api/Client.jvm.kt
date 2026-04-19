package io.github.shalva97.overwatch_player_search_api

import io.github.shalva97.overwatch_player_search_api.data.parser.installJsonParser
import io.github.shalva97.overwatch_player_search_api.data.parser.jsonParser
import io.ktor.client.HttpClient
import io.ktor.client.engine.ProxyConfig
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import javax.net.ssl.HostnameVerifier
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

public actual fun httpClient(
    proxy: ProxyConfig?,
    ignoreCertificateErrors: Boolean
): HttpClient {
    return HttpClient(OkHttp) {
        engine {
            proxy?.let {
                this.proxy = it
            }
            if (ignoreCertificateErrors) {
                // Trust all certificates
                val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
                    override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {}
                    override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {}
                    override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
                })
                val sslContext = SSLContext.getInstance("SSL")
                sslContext.init(null, trustAllCerts, SecureRandom())
                val sslSocketFactory = sslContext.socketFactory
                config {
                    sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
                    hostnameVerifier { _, _ -> true }
                }
            }
        }
        installJsonParser()
    }
}
