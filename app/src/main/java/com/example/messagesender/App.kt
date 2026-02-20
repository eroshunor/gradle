package com.example.messagesender


import android.app.Application
import android.util.Log
import androidx.work.Configuration
import com.example.messagesender.data.worker.MessageWorkerFactory
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App: Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: MessageWorkerFactory

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setMinimumLoggingLevel(Log.DEBUG)
            .setWorkerFactory(workerFactory)
            .build()
}