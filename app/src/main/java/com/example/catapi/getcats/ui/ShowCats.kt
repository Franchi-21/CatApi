package com.example.catapi.getcats.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.catapi.data.domain.entities.Cat
import com.example.catapi.getcats.GetCatsViewModel

@Composable
fun ShowCats(vm: GetCatsViewModel) {
    val catList by vm.catList.collectAsState()
    vm.getAllCats()
    ShowCatList(catList = catList)
}

@Composable
private fun ShowCatList(catList: List<Cat>) {
    LazyColumn(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth(),
    ) {
        items(catList) {
            CatCard(cat = it)
        }
    }
}

@Composable
private fun CatCard(cat: Cat) {
    Card(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .width(200.dp)
            .height(200.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xffff9cb8)),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        shape = RectangleShape,
    ) {
        AsyncImage(
            model = cat.url,
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .size(125.dp)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Crop,
        )
        Text(
            text = "ID: ${cat.id}",
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
    }
}
