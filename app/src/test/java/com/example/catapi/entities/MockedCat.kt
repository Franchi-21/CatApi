package com.example.catapi.entities

data class MockedCat(
    val breeds: List<Breed>,
    val categories: List<Category>,
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
)
