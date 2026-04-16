package com.killqwerty.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.killqwerty.android.presentation.navigation.MainNavHost
import com.killqwerty.android.presentation.navigation.MainNavigationBar
import com.killqwerty.android.ui.theme.KillqwertyAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navHostController = rememberNavController()
            KillqwertyAndroidTheme {
                MainScreen(navHostController)
            }

        }
    }
}

@Composable
fun MainScreen(navHostController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            MainNavigationBar(navHostController)
        }
    ) { paddingValues ->
        Column() {
            MainNavHost(navHostController, Modifier.padding(paddingValues))

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KillqwertyAndroidTheme(darkTheme = false) {
        MainScreen(rememberNavController())
    }
}