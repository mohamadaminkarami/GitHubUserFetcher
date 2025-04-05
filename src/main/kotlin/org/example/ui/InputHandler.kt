package org.example.ui

object InputHandler {
    fun promptUsername(): String {
        print("Enter GitHub username: ")
        return readlnOrNull()?.trim().orEmpty()
    }

    fun promptRepoName(): String {
        print("Enter repository name to search: ")
        return readlnOrNull()?.trim().orEmpty()
    }

    fun pause() {
        println("\nPress Enter to continue...")
        readlnOrNull()
    }
}
