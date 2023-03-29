package com.example.catapi.data.domain

import com.example.catapi.BuildConfig
import com.example.catapi.data.domain.entities.ApiService
import com.example.catapi.data.domain.entities.Cat
import javax.inject.Inject

class CatListUseCase @Inject constructor(
    private val apiService: ApiService,
) {
    suspend fun getAllCats(): List<Cat> {
        val catList = apiService.getAllCats(apiKey = BuildConfig.API_KEY, limit = "25")
        return catList.body() ?: emptyList()
    }
}
