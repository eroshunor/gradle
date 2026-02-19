    package com.example.messagesender.presentation.contact_details

    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.padding
    import androidx.compose.material.icons.Icons
    import androidx.compose.material.icons.automirrored.filled.ArrowBack
    import androidx.compose.material.icons.filled.CalendarMonth
    import androidx.compose.material.icons.filled.DirectionsCar
    import androidx.compose.material.icons.filled.Person
    import androidx.compose.material.icons.filled.Phone
    import androidx.compose.material3.ElevatedButton
    import androidx.compose.material3.ExperimentalMaterial3Api
    import androidx.compose.material3.Icon
    import androidx.compose.material3.IconButton
    import androidx.compose.material3.Scaffold
    import androidx.compose.material3.Text
    import androidx.compose.material3.TextField
    import androidx.compose.material3.TopAppBar
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.collectAsState
    import androidx.compose.runtime.getValue
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.unit.dp
    import com.example.messagesender.presentation.components.CustomTextField

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ContactDetailsScreen(
        viewModel: ContactDetailsViewModel,
        modifier: Modifier,
        onBack: () -> Unit
    ) {
        val uiState by viewModel.uiState.collectAsState()

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Kontakt mododitasa") },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = null
                            )
                        }
                    }
                )

            },
            content = { paddingValues ->
                Column(
                    modifier = modifier.padding(paddingValues),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CustomTextField(
                        value = uiState.name,
                        onValueChange = viewModel::onNameChange,
                        label ="Nev",
                        placeholder = "Peter Pal" ,
                        leadingIconImageVector = Icons.Filled.Person,
                        trailingIconOnClick = {}
                    )
                    CustomTextField(
                        value = uiState.licensePlate,
                        onValueChange = viewModel::onLicensePlateChange,
                        label ="Rendszam",
                        placeholder = "CV01BMW" ,
                        leadingIconImageVector = Icons.Filled.DirectionsCar,
                        trailingIconOnClick = {}
                    )
                    CustomTextField(
                        value = uiState.phoneNumber,
                        onValueChange = viewModel::onPhoneNumberChange,
                        label ="Telefonszam",
                        placeholder = "0123456789" ,
                        leadingIconImageVector = Icons.Filled.Phone,
                        trailingIconOnClick = {}
                    )
                    CustomTextField(
                        value = uiState.timeStamp,
                        onValueChange = viewModel::onTimeStampChange,
                        label ="Lejarasi datum",
                        placeholder = "2026.01.01" ,
                        leadingIconImageVector = Icons.Filled.CalendarMonth,
                        trailingIconOnClick = {}
                    )

                    ElevatedButton(
                        modifier = Modifier.fillMaxWidth().padding(start = 5.dp, end = 5.dp,top = 40.dp, bottom = 20.dp),
                        onClick = {
                            viewModel.editContact()
                            onBack()
                        },
                        content = { Text("Mododitas") }
                    )

                    ElevatedButton(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 5.dp),
                        onClick = {
                            viewModel.deleteContact()
                            onBack()
                        },
                        content = { Text("Torles") }
                    )
                }
            }
        )

    }