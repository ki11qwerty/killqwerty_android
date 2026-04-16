package com.killqwerty.android.presentation.news

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NewsScreen(){

    Scaffold() { paddingValues ->
        Text("NewsScreen", modifier = Modifier.padding(paddingValues))
    }
}