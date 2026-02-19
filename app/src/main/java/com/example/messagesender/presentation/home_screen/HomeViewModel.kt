package com.example.messagesender.presentation.home_screen

import androidx.lifecycle.ViewModel
import com.example.messagesender.domain.use_case.SendMessageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val sendMessageUseCase: SendMessageUseCase
) : ViewModel() {

    fun sendMessage() {
        sendMessageUseCase.invoke(
            phoneNumber = "1324234",
            message = "Uzi elkuldve"
        )
    }
}

