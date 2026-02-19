package com.example.messagesender.presentation.contact_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.messagesender.domain.model.Contact
import com.example.messagesender.domain.use_case.DeleteContactUseCase
import com.example.messagesender.domain.use_case.GetContactByIdUseCase
import com.example.messagesender.domain.use_case.InsertContactUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getContactByIdUseCase: GetContactByIdUseCase,
    private val insertContactUseCase: InsertContactUseCase,
    private val deleteContactUseCase: DeleteContactUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(ContactDetailsUiState())
    val uiState: StateFlow<ContactDetailsUiState> = _uiState.asStateFlow()

    private val contactId: Int =
        savedStateHandle["contactId"]
            ?: error("contactId missing from navigation arguments")

    init {
        getContactData(contactId = contactId)
    }

    fun onNameChange(value: String) {
        _uiState.update { it.copy(name = value) }
    }

    fun onLicensePlateChange(value: String) {
        _uiState.update { it.copy(licensePlate = value) }
    }

    fun onTimeStampChange(value: String) {
        _uiState.update { it.copy(timeStamp = value) }
    }

    fun onPhoneNumberChange(value: String) {
        _uiState.update { it.copy(phoneNumber = value) }
    }
    fun getContactData(contactId: Int) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)

            val contact = getContactByIdUseCase(contactId)

            if (contact != null) {
                _uiState.value = _uiState.value.copy(
                    name = contact.name,
                    licensePlate = contact.licensePlate,
                    phoneNumber = contact.phoneNumber,
                    timeStamp = contact.timeStamp,
                    isLoading = false,
                    error = null
                )
            } else {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = "Kontakt nem található"
                )
            }

        }
    }

    fun editContact() {
        viewModelScope.launch {
            insertContactUseCase.invoke(
                contact = Contact(
                    id = contactId,
                    name = uiState.value.name,
                    licensePlate = uiState.value.licensePlate,
                    timeStamp = uiState.value.timeStamp,
                    phoneNumber = uiState.value.phoneNumber,
                )
            )
        }
    }
    fun deleteContact() {
        viewModelScope.launch {
            deleteContactUseCase.invoke(
                contact = Contact(
                    id = contactId,
                    name = uiState.value.name,
                    licensePlate = uiState.value.licensePlate,
                    timeStamp = uiState.value.timeStamp,
                    phoneNumber = uiState.value.phoneNumber,
                )
            )
        }
    }
}
