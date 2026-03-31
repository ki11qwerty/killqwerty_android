package com.killqwerty.android.data.remote.news

import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("apiKey") apiKey: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int = 100,
        @Query("country") country: String = "us"
    ): NewsApiResponseDto

    @GET("v2/everything")
    suspend fun getEverything(
        @Query("apiKey") apiKey: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int = 100,
        @Query("language") language: String = "ru",
        @Query("q") query: String = "news"
    ): NewsApiResponseDto
}