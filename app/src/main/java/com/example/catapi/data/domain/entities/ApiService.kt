package com.example.catapi.data.domain.entities

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v1/images/search")
    suspend fun getAllCats(
        @Query("api_key") apiKey: String,
        @Query("limit") limit: String,
    ): Response<List<Cat>>
}
