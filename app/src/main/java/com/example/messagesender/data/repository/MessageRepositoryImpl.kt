package com.example.messagesender.data.repository

import android.content.Context
import android.telephony.SmsManager
import com.example.messagesender.domain.repository.MessageRepository

class MessageRepositoryImpl(
    private val context: Context
): MessageRepository {
    override fun sendMessage(phoneNumber: String, message: String) {
        try {
            val smsManager = context.getSystemService(SmsManager::class.java).createForSubscriptionId(1)
            smsManager.sendTextMessage(
                phoneNumber,
                null,
                message,
                null,
                null
            )
            println("KORTE + " + "minden szep es jo")
        } catch (e: Exception) {
            println("KORTE + " + e.message)
        }
    }
}