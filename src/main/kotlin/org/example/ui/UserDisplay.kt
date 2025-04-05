package org.example.ui

import org.example.model.GitHubUser
import org.example.model.Repo

object UserDisplay {
    fun showUser(user: GitHubUser) {
        println("------------ User Info ------------")
        println("Username: ${user.username}")
        println("Name: ${user.name ?: "N/A"}")
        println("Followers: ${user.followers}")
        println("Following: ${user.following}")
        println("Account Created: ${user.createdAt}")
        println("Public Repositories:")
        user.repos.forEach {
            println("- ${it.name}: ${it.description ?: "No description"}")
        }
        println("-----------------------------------\n")
    }

    fun showUsers(users: Collection<GitHubUser>) {
        if (users.isEmpty()) {
            println("No users in memory.")
        } else {
            println("Stored GitHub Users:")
            users.forEach {
                println("- ${it.username} (${it.name ?: "N/A"})")
            }
        }
        println()
    }

    fun showUserSearchResults(results: List<GitHubUser>) {
        if (results.isEmpty()) {
            println("No users found.")
        } else {
            println("Search Results:")
            results.forEach {
                println("- ${it.username} (${it.name ?: "N/A"})")
            }
        }
    }

    fun showRepoSearchResults(results: List<Pair<Repo, GitHubUser>>) {
        if (results.isEmpty()) {
            println("No repos found.")
        } else {
            println("Search Results:")
            results.forEach {
                println(
                    "- ${it.first.name}: ${it.first.description ?: "No description"}"
                            + " by ${it.second.username} (${it.second.name ?: "N/A"})"
                )

            }
        }
    }
}
