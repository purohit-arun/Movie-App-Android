package com.example.allinoneapppractise.di_cheezy_code

import com.example.allinoneapppractise.di_cheezy_code.DIDemoActivity
import com.example.allinoneapppractise.di_cheezy_code.NotificationServiceModule
import com.example.allinoneapppractise.di_cheezy_code.UserRepositoryModule
import com.example.allinoneapppractise.handler_and_looperbycodinginflow.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [UserRepositoryModule::class, NotificationServiceModule::class])
interface UserRegistrationComponent {
    fun inject(mainActivity: DIDemoActivity)

    //to make factory
    @Component.Factory
    interface Factory{
        fun create(@BindsInstance retryCount:Int) : UserRegistrationComponent
    }
}