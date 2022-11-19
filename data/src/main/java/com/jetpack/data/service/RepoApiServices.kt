package com.jetpack.data.service

import com.jetpack.api_response.ProfileApiResponse
import com.jetpack.api_response.RepoApiResponseItem
import retrofit2.Response
import retrofit2.http.*

interface RepoApiServices {

    @GET("/users/{username}/repos")
    suspend fun fetchRepoList(
        @Path("username")username:String
    ): Response<List<RepoApiResponseItem>>

    @GET("/users/{username}")
    suspend fun fetchProfile(
        @Path("username")username:String
    ):Response<ProfileApiResponse>
}