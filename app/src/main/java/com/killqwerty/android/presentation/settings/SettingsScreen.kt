package com.killqwerty.android.presentation.settings

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SettingsScreen(){
    Scaffold() { paddingValues ->
        Text("SettingsScreen", modifier = Modifier.padding(paddingValues))
    }
}