package com.skubawa.doragon.watcher.services

import io.ktor.client.*

class DoragonApiService(private val httpClient: HttpClient) {
    var queue: DoragonApiQueueService = DoragonApiQueueService(httpClient)
        private set
}