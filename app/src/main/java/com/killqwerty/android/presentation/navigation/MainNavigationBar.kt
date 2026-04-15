package com.killqwerty.android.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.killqwerty.android.presentation.navigation.Destination.News
import com.killqwerty.android.presentation.navigation.Destination.Training

@Composable
fun MainNavigationBar(navHostController: NavHostController){
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