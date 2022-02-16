package com.example.allinoneapppractise.di_cheezy_code

import dagger.Module
import dagger.Provides

@Module
class NotificationServiceModule {
    @Provides
    fun getMessageService():NotificationService{
        return MessageService()
    }
}