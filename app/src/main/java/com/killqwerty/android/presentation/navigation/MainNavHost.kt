package com.killqwerty.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.killqwerty.android.presentation.news.NewsScreen
import com.killqwerty.android.presentation.settings.SettingsScreen
import com.killqwerty.android.presentation.training.TrainingScreen

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Destination.NewsScreen.route,
    ) {

        composable(route = Destination.NewsScreen.route) {

            NewsScreen()

        }

        composable(route = Destination.TrainingScreen.route) {

            TrainingScreen()

        }

        composable(route = Destination.SettingsScreen.route) {

            SettingsScreen()

        }
    }
}

sealed class Destination(val route : String){
    data object NewsScreen : Destination(NEWS)
    data object TrainingScreen : Destination(TRAINING)
    data object SettingsScreen : Destination(SETTINGS)
    companion object {
        private const val NEWS = "news"
        private const val TRAINING = "training"
        private const val SETTINGS = "settings"
    }
}