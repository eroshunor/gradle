package com.example.messagesender.domain.use_case

import com.example.messagesender.domain.model.User
import com.example.messagesender.domain.repository.UserRepository

class GetUserByIdUseCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(id: Int): User? {
        return userRepository.getUserById(id = id)
    }
}