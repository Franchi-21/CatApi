package com.example.catapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.catapi.getcats.GetCatsViewModel
import com.example.catapi.getcats.ui.ShowCats
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val getCatsVM by viewModels<GetCatsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowCats(vm = getCatsVM)
        }
    }
}
