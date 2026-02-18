package com.example.messagesender.domain.use_case

import com.example.messagesender.domain.model.User
import com.example.messagesender.domain.repository.UserRepository

class InsertUserUseCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(user: User) {
        return userRepository.insertUser(user = user)
    }
}