package com.example.messagesender.domain.use_case

import com.example.messagesender.domain.model.Contact
import com.example.messagesender.domain.repository.ContactRepository

class GetContactByIdUseCase(
    private val contactRepository: ContactRepository
) {
    suspend operator fun invoke(id: Int): Contact? {
        return contactRepository.getContactById(id = id)
    }
}