package com.skubawa.doragon.watcher

class ArgParser {
    fun parse(args: Array<String>): Array<String> {
        if(args.size < 2) {
            throw IllegalArgumentException("--path is required.")
        }
        val (argument, filepath) = args

        val pathArgInformed: Boolean = argument == "--path"

        if(!pathArgInformed) {
            throw IllegalArgumentException("--path is required")
        }

        val filepathIsEmpty: Boolean = filepath == ""

        if(filepathIsEmpty) {
            throw IllegalArgumentException("--path is empty. Inform a valid filepath.")
        }

        return arrayOf(argument, filepath)
    }
}