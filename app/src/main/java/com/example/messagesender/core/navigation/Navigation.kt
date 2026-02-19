package com.example.messagesender.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.messagesender.presentation.add_contact.AddContactScreen
import com.example.messagesender.presentation.add_contact.AddContactViewModel
import com.example.messagesender.presentation.contact_details.ContactDetailsScreen
import com.example.messagesender.presentation.contact_details.ContactDetailsViewModel
import com.example.messagesender.presentation.contact_list.ContactListScreen
import com.example.messagesender.presentation.contact_list.ContactListViewModel
import kotlinx.serialization.Serializable

@Composable
fun Navigation(
    modifier: Modifier
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ContactListScreen
    ) {
        composable<ContactListScreen> {
            val viewModel: ContactListViewModel = hiltViewModel()
            ContactListScreen(
                viewModel = viewModel,
                modifier = modifier,
                navigateToAddContactScreen = { navController.navigate(AddContactScreen) },
                navigateToContactDetailsScreen = { contactId ->
                    navController.navigate(ContactDetailsScreen(contactId = contactId))
                }
            )
        }
        composable<AddContactScreen> {
            val viewModel: AddContactViewModel = hiltViewModel()
            AddContactScreen(
                viewModel = viewModel,
                modifier = modifier,
                onBack = { navController.popBackStack() }
            )
        }
        composable<ContactDetailsScreen> {
            val viewModel: ContactDetailsViewModel = hiltViewModel()
            ContactDetailsScreen(
                viewModel = viewModel,
                modifier = modifier,
                onBack = { navController.popBackStack() }
            )
        }
    }
}

@Serializable
object ContactListScreen

@Serializable
object AddContactScreen

@Serializable
data class ContactDetailsScreen(val contactId: Int)