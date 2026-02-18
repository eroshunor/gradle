package com.example.messagesender.domain.repository

import com.example.messagesender.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getAllUsers() : Flow<List<User>>

    suspend fun getUserById(id: Int) : User?

    suspend fun insertUser(user: User)

    suspend fun deleteUser(user: User)
}