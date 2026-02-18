package com.example.messagesender.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.messagesender.domain.model.User

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)
abstract class UserDatabase: RoomDatabase() {
    abstract val userDao: UserDao

    companion object {
        const val DATABASE_NAME = "users_db"
    }
}