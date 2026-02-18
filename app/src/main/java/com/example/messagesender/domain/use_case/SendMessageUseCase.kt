package com.example.messagesender.domain.use_case

import com.example.messagesender.domain.repository.MessageRepository

class SendMessageUseCase(
    private val messageRepository: MessageRepository
) {
    operator fun invoke(phoneNumber: String, message: String) {
        messageRepository.sendMessage(phoneNumber = phoneNumber, message = message)
    }
}