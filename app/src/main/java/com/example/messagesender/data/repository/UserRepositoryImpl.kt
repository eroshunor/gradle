package com.example.messagesender.data.repository

import com.example.messagesender.data.data_source.UserDao
import kotlinx.coroutines.flow.Flow
import com.example.messagesender.domain.model.User
import com.example.messagesender.domain.repository.UserRepository

class UserRepositoryImpl(
    private val dao: UserDao
) : UserRepository {
    override fun getAllUsers(): Flow<List<User>> {
        return dao.getAllUsers()
    }

    override suspend fun getUserById(id: Int): User? {
        return dao.getUserById(id = id)
    }

    override suspend fun insertUser(user: User) {
        return dao.insertUser(user = user)
    }

    override suspend fun deleteUser(user: User) {
        return dao.deleteUser(user = user)
    }
}