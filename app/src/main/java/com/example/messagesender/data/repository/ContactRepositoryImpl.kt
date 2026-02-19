package com.example.messagesender.data.repository

import com.example.messagesender.data.data_source.ContactDao
import kotlinx.coroutines.flow.Flow
import com.example.messagesender.domain.model.Contact
import com.example.messagesender.domain.repository.ContactRepository

class ContactRepositoryImpl(
    private val dao: ContactDao
) : ContactRepository {
    override fun getAllContact(): Flow<List<Contact>> {
        return dao.getAllContacts()
    }

    override suspend fun getContactById(id: Int): Contact? {
        return dao.getContactById(id = id)
    }

    override suspend fun insertContact(contact: Contact) {
        return dao.insertContact(contact = contact)
    }

    override suspend fun deleteContact(contact: Contact) {
        return dao.deleteContact(contact = contact)
    }
}