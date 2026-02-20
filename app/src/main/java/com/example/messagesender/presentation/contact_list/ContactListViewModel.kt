package com.example.messagesender.presentation.contact_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.messagesender.domain.use_case.GetAllContactsUseCase
import com.example.messagesender.domain.use_case.ScheduleMessageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactListViewModel @Inject constructor(
    private val getAllContactsUseCase: GetAllContactsUseCase,
    private val scheduleMessageUseCase: ScheduleMessageUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(ContactListUiState(isLoading = true))
    val uiState: StateFlow<ContactListUiState> = _uiState.asStateFlow()

    init {
        getAllContacts()
    }

    fun getAllContacts() {
        viewModelScope.launch {
            getAllContactsUseCase.invoke().collect { contacts ->
                _uiState.value = ContactListUiState(
                    contacts = contacts,
                    isLoading = false
                )
            }
        }
    }
    fun sendMessage() {
        scheduleMessageUseCase.invoke(
    )
    }
}

