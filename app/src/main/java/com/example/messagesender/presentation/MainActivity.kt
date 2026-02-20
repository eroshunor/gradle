package com.example.messagesender.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.work.BackoffPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.messagesender.core.navigation.Navigation
import com.example.messagesender.core.ui.theme.MessageSenderTheme
import com.example.messagesender.data.worker.MessageWorker
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val workRequest = OneTimeWorkRequestBuilder<MessageWorker>()
            .setInitialDelay(10, java.util.concurrent.TimeUnit.SECONDS)
            .setBackoffCriteria(
                backoffPolicy = BackoffPolicy.LINEAR,
                duration = java.time.Duration.ofSeconds(15)
            ).build()


        WorkManager.getInstance(this).enqueue(workRequest)
        setContent {
            MessageSenderTheme {
                Scaffold(modifier = Modifier.fillMaxSize().padding(horizontal = 10.dp)) { innerPadding ->
                    Navigation(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
