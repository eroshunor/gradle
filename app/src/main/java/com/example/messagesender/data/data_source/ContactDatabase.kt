package com.example.messagesender.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.messagesender.domain.model.Contact

@Database(
    entities = [Contact::class],
    version = 1,
    exportSchema = false
)
abstract class ContactDatabase: RoomDatabase() {
    abstract val contactDao: ContactDao

    companion object {
        const val DATABASE_NAME = "contacts_db"
    }
}