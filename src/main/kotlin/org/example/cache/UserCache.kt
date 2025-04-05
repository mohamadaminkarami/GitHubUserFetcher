package org.example.cache

import org.example.model.GitHubUser
import org.example.model.Repo

object UserCache {
    private val cache = mutableMapOf<String, GitHubUser>()

    fun get(username: String): GitHubUser? = cache[username.lowercase()]

    fun put(user: GitHubUser) {
        cache[user.username.lowercase()] = user
    }

    fun allUsers(): Collection<GitHubUser> = cache.values

    fun searchByUsername(substring: String): List<GitHubUser> {
        val lower = substring.lowercase()
        return cache.values.filter { it.username.contains(lower) || (it.name?.contains(lower) == true) }
    }

    fun searchByRepoName(substring: String): List<Pair<Repo, GitHubUser>> {
        val lower = substring.lowercase()

        return cache.values.flatMap { user ->
            user.repos.filter { repo ->
                repo.name.lowercase().contains(lower)
            }.map { repo -> Pair(repo, user) }
        }
    }
}
