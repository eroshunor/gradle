package com.example.messagesender.domain.use_case

import com.example.messagesender.domain.model.Contact
import com.example.messagesender.domain.repository.ContactRepository
import kotlinx.coroutines.flow.Flow

class GetAllContactsUseCase(
    private val contactRepository: ContactRepository
) {
    operator fun invoke(): Flow<List<Contact>> {
        return contactRepository.getAllContact()
    }
}