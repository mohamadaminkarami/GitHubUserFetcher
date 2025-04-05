package org.example.model

import com.google.gson.annotations.SerializedName

data class GitHubUser(
    @SerializedName("login")
    val username: String,
    val name: String?,
    val followers: Int,
    val following: Int,
    @SerializedName("created_at")
    val createdAt: String,
    var repos: List<Repo> = emptyList()
)
