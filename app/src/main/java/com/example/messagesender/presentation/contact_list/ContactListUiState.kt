package com.example.messagesender.presentation.contact_list

import com.example.messagesender.domain.model.Contact

data class ContactListUiState(
    val contacts: List<Contact> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)