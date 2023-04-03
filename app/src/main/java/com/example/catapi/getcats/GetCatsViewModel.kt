package com.example.catapi.getcats

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catapi.data.CatListRepository
import com.example.catapi.data.domain.entities.Cat
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetCatsViewModel @Inject constructor(
    private val repository: CatListRepository,
) : ViewModel() {
    private val _catList = MutableStateFlow<List<Cat>>(emptyList())
    val catList: StateFlow<List<Cat>> = _catList

    fun getAllCats() {
        viewModelScope.launch {
            repository
                .getAllCats()
                .flowOn(Dispatchers.IO)
                .collectLatest {
                    _catList.value = it
                }
        }
    }
}
