package com.example.messagesender.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.messagesender.presentation.home_screen.HomeScreen
import kotlinx.serialization.Serializable

@Composable
fun Navigation(
    modifier: Modifier
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = HomeScreen
    ) {
        composable<HomeScreen> {
            //val viewModel: HomeViewModel = hiltViewModel()

            HomeScreen(
                modifier = modifier,
                navigateToAddContactScreen = {},
                navigateToEditContactScreen = {}
            )
        }
    }
}

@Serializable
object HomeScreen