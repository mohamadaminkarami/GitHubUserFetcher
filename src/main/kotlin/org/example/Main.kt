package org.example

import kotlinx.coroutines.runBlocking
import org.example.cache.UserCache
import org.example.network.RetrofitClient
import org.example.ui.InputHandler
import org.example.ui.MenuRenderer
import org.example.ui.UserDisplay

fun main() = runBlocking {
    while (true) {
        when (MenuRenderer.showMainMenu()) {
            1 -> {
                val username = InputHandler.promptUsername()
                val cached = UserCache.get(username)
                if (cached != null) {
                    println("Loaded from cache.")
                    UserDisplay.showUser(cached)
                } else {
                    try {
                        val user = RetrofitClient.api.getUser(username)
                        val repos = RetrofitClient.api.getUserRepos(username)
                        user.repos = repos
                        UserCache.put(user)
                        println("Fetched from API.")
                        UserDisplay.showUser(user)
                    } catch (e: Exception) {
                        println("Failed to fetch user: ${e.message}")
                    }
                }
                InputHandler.pause()
            }

            2 -> {
                UserDisplay.showUsers(UserCache.allUsers())
                InputHandler.pause()
            }

            3 -> {
                val query = InputHandler.promptUsername()
                val results = UserCache.searchByUsername(query)
                UserDisplay.showUserSearchResults(results)
                InputHandler.pause()
            }

            4 -> {
                val query = InputHandler.promptRepoName()
                val results = UserCache.searchByRepoName(query)
                UserDisplay.showRepoSearchResults(results)
                InputHandler.pause()
            }

            5 -> {
                println("Goodbye!")
                break
            }

            else -> {
                println("Invalid choice. Try again.")
            }
        }
    }
}
