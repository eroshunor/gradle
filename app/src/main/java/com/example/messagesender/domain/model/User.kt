package com.example.messagesender.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    val name: String,
    val licensePlate: String,
    val timeStamp: String,
    val phoneNumber: String,
    @PrimaryKey val id: Int? = null
)
