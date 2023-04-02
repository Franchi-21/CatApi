package com.example.catapi.entities

import retrofit2.Response
import retrofit2.http.GET

interface ApiMock {
    @GET("v3/371c6313-17e8-48a3-8f29-d78008096b7c")
    fun getMockedJSON(): Response<MockedCat>
}
