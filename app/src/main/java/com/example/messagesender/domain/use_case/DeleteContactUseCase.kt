package com.example.messagesender.domain.use_case

import com.example.messagesender.domain.model.Contact
import com.example.messagesender.domain.repository.ContactRepository

class DeleteContactUseCase(
    private val contactRepository: ContactRepository
) {
    suspend operator fun invoke(contact: Contact) {
        return contactRepository.deleteContact(contact = contact)
    }
}