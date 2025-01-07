package com.skubawa.doragon.watcher.services

import com.skubawa.doragon.watcher.Task
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class DoragonApiQueueService(private val httpClient: HttpClient) {
    suspend fun enqueue(task: Task) {
        val response = httpClient.post() {
            contentType(ContentType.Application.Json)
            setBody(task)
        }
    }
}