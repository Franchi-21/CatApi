package com.example.catapi.entities

sealed class State {
    data class Success<T>(val onSuccess: T) : State()
    data class Error<T>(val onError: T) : State()
}
