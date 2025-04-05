package org.example.network

import org.example.model.GitHubUser
import org.example.model.Repo
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubAPI {
    @GET("users/{username}")
    suspend fun getUser(@Path("username") username: String): GitHubUser

    @GET("users/{username}/repos")
    suspend fun getUserRepos(@Path("username") username: String): List<Repo>
}
