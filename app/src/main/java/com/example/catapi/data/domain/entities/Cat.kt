package com.example.catapi.data.domain.entities

data class Cat(
    val breeds: List<Breed>,
    val categories: List<Category>,
    val height: Int,
    val id: String,
    val url: String,
    val width: Int,
)

fun emptyCat() = Cat(
    breeds = emptyList(),
    categories = emptyList(),
    height = 0,
    id = "",
    url = "",
    width = 0
)