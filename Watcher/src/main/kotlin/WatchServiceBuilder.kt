package com.skubawa.doragon.watcher

import java.nio.file.FileSystems
import java.nio.file.StandardWatchEventKinds
import java.nio.file.WatchService

class WatchServiceBuilder() {
    private val filepathValidator: FilepathValidator = FilepathValidator()

    fun build(filepath: String): WatchService {
        val service = FileSystems.getDefault().newWatchService()
        val path = filepathValidator.validate(filepath)

        path.register(service, StandardWatchEventKinds.ENTRY_CREATE)

        return service
    }
}