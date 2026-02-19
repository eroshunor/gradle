package com.example.messagesender.presentation.home_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.messagesender.domain.model.Contact

@Composable
fun ContactCard(
    contact: Contact,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                BorderStroke(1.dp, Color.DarkGray),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 10.dp,vertical = 5.dp)
            .clickable(
                onClick = onClick
            ),
        horizontalArrangement = Arrangement.Absolute.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column()
        {
            Text(text = contact.name)
            Text(text = contact.licensePlate)
        }
        Text(text = contact.timeStamp)
    }
    Spacer(modifier = Modifier.padding(bottom = 10.dp))
}
