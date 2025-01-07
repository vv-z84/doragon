package com.skubawa.doragon.watcher

import com.skubawa.doragon.watcher.services.DoragonApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.nio.file.Path
import java.nio.file.StandardWatchEventKinds
import java.nio.file.WatchService

class WatcherApp(private val watchedPath: Path, private val watcherService: WatchService, private val doragonApiService: DoragonApiService) {
    suspend fun run() {
        while (true) {
            val key = withContext(Dispatchers.IO) {
                watcherService.take()
            }

            for(event in key.pollEvents()) {
                when (event.kind()) {
                     StandardWatchEventKinds.ENTRY_CREATE -> {
                         val createdFile = event.context().toString()
                         doragonApiService.queue.enqueue(Task(watchedPath.resolve(createdFile).toString()))
                     }
                }
            }

            key.reset()
        }
    }
}