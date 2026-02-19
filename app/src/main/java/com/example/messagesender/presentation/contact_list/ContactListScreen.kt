package com.example.messagesender.presentation.contact_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.messagesender.presentation.components.ContactCard

@Composable
fun ContactListScreen(
    viewModel: ContactListViewModel,
    modifier: Modifier,
    navigateToAddContactScreen: () -> Unit,
    navigateToContactDetailsScreen: (Int) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navigateToAddContactScreen()
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.PersonAdd,
                    contentDescription = null
                )
            }
        },
        content = { paddingValues ->
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(paddingValues),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { viewModel.sendMessage() },
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Email,
                            contentDescription = null
                        )
                    }

                }
                Text(
                    text = "ITP lista",
                    modifier = modifier
                )
                LazyColumn {
                    items(uiState.contacts) { contact ->
                        ContactCard(
                            contact = contact,
                            onClick = navigateToContactDetailsScreen
                        )
                    }

                }
            }
        }
    )


}
