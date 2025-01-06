package com.skubawa.doragon.watcher

import java.io.File

class FilepathValidator {
    fun validate(filepath: String): Boolean {
        val file = File(filepath)

        if(!file.exists()) {
            throw RuntimeException("$filepath does not exists.")
        }

        if(!file.canRead()) {
            throw RuntimeException("can't read $filepath")
        }

        return true
    }
}