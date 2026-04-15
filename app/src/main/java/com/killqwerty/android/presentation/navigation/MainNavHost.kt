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
        startDestination = Destination.News.route,
    ) {

        composable(route = Destination.News.route) {

            NewsScreen()

        }

        composable(route = Destination.Training.route) {

            TrainingScreen()

        }

        composable(route = Destination.Settings.route) {

            SettingsScreen()

        }
    }
}

sealed class Destination(val route : String){
    data object News : Destination(NEWS)
    data object Training : Destination(TRAINING)
    data object Settings : Destination(SETTINGS)
    companion object {
        private const val NEWS = "news"
        private const val TRAINING = "training"
        private const val SETTINGS = "settings"
    }
}