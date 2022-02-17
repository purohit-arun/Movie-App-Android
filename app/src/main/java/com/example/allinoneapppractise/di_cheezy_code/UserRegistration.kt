package com.example.allinoneapppractise.di_cheezy_code

import com.example.allinoneapppractise.di_cheezy_code.NotificationService
import com.example.allinoneapppractise.di_cheezy_code.UserRepository
import javax.inject.Inject
import javax.inject.Named


class UserRegistrationService @Inject constructor(
    private val userRepos: UserRepository,
    @MessageQualifier
    private val notificationService: NotificationService
) {
    fun registerUser(email: String, password: String) {
        userRepos.saveUser(email, password)
        notificationService.send("Registration done", "apurohit@bosleo.com", "to-non_reply@cognizant.com")
    }
}

