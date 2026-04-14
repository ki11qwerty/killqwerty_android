package com.killqwerty.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.twotone.AccountCircle
import androidx.compose.material.icons.twotone.Favorite
import androidx.compose.material.icons.twotone.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.killqwerty.android.presentation.navigation.Destination
import com.killqwerty.android.presentation.navigation.Destination.News
import com.killqwerty.android.presentation.navigation.Destination.Training
import com.killqwerty.android.presentation.navigation.MainNavHost
import com.killqwerty.android.presentation.news.NewsScreen
import com.killqwerty.android.ui.theme.KillqwertyAndroidTheme
import com.killqwerty.android.ui.theme.someTestTextColor

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
            NavigationBar() {
                NavigationBarItem(
                    selected = navHostController.currentDestination?.route == News.route,
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "",
                            tint = Color.Red,
                        )
                    },
                    label = { Text("News") },
                    onClick = {
                        navHostController.navigate(Destination.News.route)
                    }
                )
                NavigationBarItem(
                    selected = navHostController.currentDestination?.route == Training.route,
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.AccountCircle,
                            tint = Color.Red,
                            contentDescription = ""
                        )
                    },
                    label = { Text("Training") },
                    onClick = {
                        navHostController.navigate(Destination.Training.route)
                    }
                )
                NavigationBarItem(
                    selected = navHostController.currentDestination?.route == Destination.Settings.route,
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Settings,
                            tint = Color.Red,
                            contentDescription = ""
                        )
                    },
                    label = { Text("Settings") },
                    onClick = {
                        navHostController.navigate(Destination.Settings.route)
                    }
                )
            }
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