package com.skubawa.doragon.watcher.http

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*

class KtorHttpClientBuilder {
    fun build(engine: HttpClientEngine): HttpClient {
        return HttpClient(engine) {
            expectSuccess = true
            defaultRequest {
                url(System.getenv("DORAGON_API_BASE_URL"))
            }
            install(ContentNegotiation) {
                json()
            }
            install(Logging)
        }
    }
}