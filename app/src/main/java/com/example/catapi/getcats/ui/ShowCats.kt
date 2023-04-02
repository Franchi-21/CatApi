package com.example.catapi.getcats.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.catapi.data.domain.entities.Cat
import com.example.catapi.getcats.GetCatsViewModel

@Composable
fun ShowCats(vm: GetCatsViewModel) {
    val catList by vm.cats.collectAsState()
    vm.getAllCats()
    ShowCatList(catList = catList)
}

@Composable
private fun ShowCatList(catList: List<Cat>) {
    LazyColumn(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(catList) {
            CatCard(cat = it)
        }
    }
}

@Composable
private fun CatCard(cat: Cat) {
    Card(modifier = Modifier.fillMaxWidth()) {
    }
}
