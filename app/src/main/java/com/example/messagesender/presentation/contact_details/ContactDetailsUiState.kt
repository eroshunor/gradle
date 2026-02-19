package com.example.messagesender.presentation.contact_details

data class ContactDetailsUiState(
    val name: String = "",
    val licensePlate: String = "",
    val timeStamp: String = "",
    val phoneNumber: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
)