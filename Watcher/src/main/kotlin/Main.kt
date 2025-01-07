package com.skubawa.doragon.watcher

import com.skubawa.doragon.watcher.http.KtorHttpClientBuilder
import com.skubawa.doragon.watcher.services.DoragonApiService
import io.ktor.client.engine.cio.*

val REQUIRED_ENV_VARS = listOf("DORAGON_API_BASE_URL")

suspend fun main(args: Array<String>) {
    validateEnvVars()
    val argParser = ArgParser()
    val (_, filepath) = argParser.parse(args)
    val validFilepath = FilepathValidator().validate(filepath)

    val watchService = WatchServiceBuilder().build(validFilepath.toString())

    val doragonApiService = DoragonApiService(KtorHttpClientBuilder().build(CIO.create()))

    val app = WatcherApp(validFilepath, watchService, doragonApiService)
    app.run()
}

fun validateEnvVars() {
    val env = System.getenv()
    val missingEnvVars = REQUIRED_ENV_VARS.filterNot { envVar -> env.keys.contains(envVar) }

    if(missingEnvVars.isNotEmpty()) {
        println("Missing environment variables: ${missingEnvVars.joinToString(", ")}")
        throw RuntimeException("Missing environment variables.")
    }
}