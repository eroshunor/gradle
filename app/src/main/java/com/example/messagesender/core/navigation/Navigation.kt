package com.example.messagesender.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.messagesender.presentation.contact_details.ContactDetailsScreen
import com.example.messagesender.presentation.home_screen.HomeScreen
import com.example.messagesender.presentation.home_screen.HomeViewModel
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
            val viewModel: HomeViewModel = hiltViewModel()
            HomeScreen(
                viewModel = viewModel,
                modifier = modifier,
                navigateToContactDetailsScreen = { navController.navigate(ContactDetailsScreen) }
            )
        }
        composable<ContactDetailsScreen> {
            ContactDetailsScreen(
                modifier = modifier,
                onBack = { navController.popBackStack() }
            )
        }
    }
}

@Serializable
object HomeScreen

@Serializable
object ContactDetailsScreen