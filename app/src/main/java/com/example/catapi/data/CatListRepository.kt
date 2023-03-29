package com.example.catapi.data

import com.example.catapi.data.domain.CatListUseCase
import com.example.catapi.data.domain.entities.Cat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CatListRepository @Inject constructor(
    private val catListUseCase: CatListUseCase,
) {
    fun getAllCats(): Flow<List<Cat>> = flow {
        val catList = catListUseCase.getAllCats()
        emit(catList)
    }
}
