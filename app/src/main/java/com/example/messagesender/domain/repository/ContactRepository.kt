package com.example.messagesender.domain.repository

import com.example.messagesender.domain.model.Contact
import kotlinx.coroutines.flow.Flow

interface ContactRepository {

    fun getAllContact() : Flow<List<Contact>>

    suspend fun getContactById(id: Int) : Contact?

    suspend fun insertContact(contact: Contact)

    suspend fun deleteContact(contact: Contact)
}