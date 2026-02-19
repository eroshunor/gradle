package com.example.messagesender.presentation.home_screen

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.messagesender.presentation.home_screen.components.ContactCard
import com.example.messagesender.domain.model.Contact

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    modifier: Modifier,
    navigateToContactDetailsScreen: () -> Unit,
) {
    Column{
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { viewModel.sendMessage() },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_dialog_email),
                    contentDescription = "Send test SMS"
                )
            }
            Text(
                text = "ITP lista",
                modifier = modifier
            )
        }

        LazyColumn {
            items(20) { index ->
                ContactCard(
                    contact = Contact(
                        name = "PETER PAL $index",
                        licensePlate = "CV 01 BMW $index",
                        timeStamp = "2026.01.01",
                        phoneNumber = "123"
                    ),
                    onClick = navigateToContactDetailsScreen
                )
            }

        }
    }

}
