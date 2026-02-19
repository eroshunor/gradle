package com.example.messagesender.presentation.add_contact

data class AddContactUiState(
    val name: String = "",
    val licensePlate: String = "",
    val timeStamp: String = "",
    val phoneNumber: String = "",
    val isSaving: Boolean = false,
    val error: String? = null
)