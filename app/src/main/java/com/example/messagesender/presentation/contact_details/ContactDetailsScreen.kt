package com.example.messagesender.presentation.contact_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.messagesender.core.navigation.ContactDetailsScreen

@Composable
fun ContactDetailsScreen(
    modifier: Modifier,
    onBack: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("EDIT CONTACT", modifier = Modifier.padding(top = 50.dp))
        Text("EDIT CONTACT", modifier = Modifier.padding(top = 50.dp))
        Text("EDIT CONTACT", modifier = Modifier.padding(top = 50.dp))
        Text("EDIT CONTACT", modifier = Modifier.padding(top = 50.dp))
    }
}