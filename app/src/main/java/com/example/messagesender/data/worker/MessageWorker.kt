package com.example.messagesender.data.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.messagesender.domain.use_case.SendMessageUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject


@HiltWorker
class MessageWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    @Assisted private val sendMessageUseCase: SendMessageUseCase
) : Worker(context, params) {

    override fun doWork(): Result {
       sendMessageUseCase.invoke(phoneNumber = "+40740617235", message = "Hello bello, ez itt mar az uj appbol jon csak meg nem idozitve lol.")
       println("korte csao")
        return Result.success()
    }
}