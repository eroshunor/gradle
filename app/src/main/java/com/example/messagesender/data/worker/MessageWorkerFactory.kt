package com.example.messagesender.data.worker

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.example.messagesender.domain.use_case.SendMessageUseCase
import javax.inject.Inject

class MessageWorkerFactory @Inject constructor(private val sendMessageUseCase: SendMessageUseCase) : WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker
            = MessageWorker(context = appContext, params = workerParameters, sendMessageUseCase = sendMessageUseCase)
}