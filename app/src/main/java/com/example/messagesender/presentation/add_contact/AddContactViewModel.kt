package com.example.messagesender.presentation.add_contact

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.messagesender.domain.model.Contact
import com.example.messagesender.domain.use_case.InsertContactUseCase
import com.example.messagesender.presentation.components.ContactFieldType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddContactViewModel @Inject constructor(
    private val insertContactUseCase: InsertContactUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(AddContactUiState())
    val uiState: StateFlow<AddContactUiState> = _uiState.asStateFlow()


    fun onContactFieldChange(field: ContactFieldType, value: String = "") {
        _uiState.update {
            when (field) {
                ContactFieldType.NAME ->
                    it.copy(name = value)

                ContactFieldType.LICENSE_PLATE ->
                    it.copy(licensePlate = value)

                ContactFieldType.PHONE ->
                    it.copy(phoneNumber = value)

                ContactFieldType.TIMESTAMP ->
                    it.copy(timeStamp = value)
            }
        }
    }
     fun insertContact() {
        viewModelScope.launch {
            insertContactUseCase.invoke(
                contact = Contact(
                    name = uiState.value.name,
                    licensePlate = uiState.value.licensePlate,
                    timeStamp = uiState.value.timeStamp,
                    phoneNumber = uiState.value.phoneNumber,
                )
            )
        }
    }

}