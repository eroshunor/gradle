package com.example.messagesender.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.messagesender.data.data_source.ContactDatabase
import com.example.messagesender.data.repository.MessageRepositoryImpl
import com.example.messagesender.data.repository.ContactRepositoryImpl
import com.example.messagesender.domain.repository.MessageRepository
import com.example.messagesender.domain.repository.ContactRepository
import com.example.messagesender.domain.use_case.DeleteContactUseCase
import com.example.messagesender.domain.use_case.GetAllContactsUseCase
import com.example.messagesender.domain.use_case.GetContactByIdUseCase
import com.example.messagesender.domain.use_case.InsertContactUseCase
import com.example.messagesender.domain.use_case.SendMessageUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideContactDatabase(app: Application): ContactDatabase {
        return Room.databaseBuilder(
            app,
            ContactDatabase::class.java,
            ContactDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideContactRepository(db: ContactDatabase): ContactRepository {
        return ContactRepositoryImpl(db.contactDao)
    }

    @Provides
    @Singleton
    fun provideMessageRepository(
        @ApplicationContext context: Context
    ): MessageRepository {
        return MessageRepositoryImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideGetAllContactsUseCase(contactRepository: ContactRepository): GetAllContactsUseCase {
        return GetAllContactsUseCase(contactRepository = contactRepository)
    }

    @Provides
    @Singleton
    fun provideGetContactByIdUseCase(contactRepository: ContactRepository): GetContactByIdUseCase {
        return GetContactByIdUseCase(contactRepository = contactRepository)
    }

    @Provides
    @Singleton
    fun provideInsertContactUseCase(contactRepository: ContactRepository): InsertContactUseCase {
        return InsertContactUseCase(contactRepository = contactRepository)
    }

    @Provides
    @Singleton
    fun provideDeleteContactUseCase(contactRepository: ContactRepository): DeleteContactUseCase {
        return DeleteContactUseCase(contactRepository = contactRepository)
    }

    @Provides
    @Singleton
    fun provideSendMessageUseCase(messageRepository: MessageRepository): SendMessageUseCase {
        return SendMessageUseCase(messageRepository = messageRepository)
    }

    /*@HiltWorker
    class SmsWorker @AssistedInject constructor(
        @Assisted appContext: Context,
        @Assisted workerParams: WorkerParameters,
        private val sendMessageUseCase: SendMessageUseCase,
    ) : Worker(appContext, workerParams) {

        override fun doWork(): Result {
            sendMessageUseCase(
                phoneNumber = "+40735211195",
                message = "Ez az uzenet..."
            )
            return Result.success()
        }
    }*/
}