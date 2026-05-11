package com.killqwerty.android.presentation.news

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NewsScreen(){
    Scaffold() { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues).fillMaxSize()) {
            Text("NewsScreen", modifier = Modifier.align(Alignment.Center))
        }

    }
}
@Composable
@Preview
fun PrevNews(){
    NewsScreen()
}