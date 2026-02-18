package com.example.messagesender.domain.repository

interface MessageRepository {

    fun sendMessage(phoneNumber: String, message: String)

    //fun scheduleMessage(hour: Int, minute: Int)
}