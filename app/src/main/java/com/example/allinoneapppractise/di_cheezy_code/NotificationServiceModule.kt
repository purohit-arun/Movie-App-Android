package com.example.allinoneapppractise.di_cheezy_code

import dagger.Module
import dagger.Provides

@Module
class NotificationServiceModule() {
    @Provides
    @MessageQualifier
    fun getMessageService(retryCount:Int): NotificationService {
        return MessageService(retryCount)
    }

    @Provides
    @EmailQualifier
    fun getEmailService(emailService: EmailService): NotificationService {
        return emailService
    }
}