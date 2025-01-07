package com.skubawa.doragon.watcher

import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.exists
import kotlin.io.path.isReadable

class FilepathValidator {
    fun validate(filepath: String): Path {
        val path = Paths.get(filepath)

        if(!path.isAbsolute) {
            throw RuntimeException("Only absolute path is allowed.")
        }

        if(!path.exists()) {
            throw RuntimeException("$filepath does not exists.")
        }

        if(!path.isReadable()) {
            throw RuntimeException("can't read $filepath")
        }

        return path
    }
}