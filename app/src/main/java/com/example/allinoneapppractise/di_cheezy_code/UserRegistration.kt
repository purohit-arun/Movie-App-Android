package com.example.allinoneapppractise.di_cheezy_code

import com.example.allinoneapppractise.di_cheezy_code.NotificationService
import com.example.allinoneapppractise.di_cheezy_code.UserRepository
import javax.inject.Inject


class UserRegistrationService @Inject constructor(
    private val userRepos: UserRepository,
    private val notificationService: NotificationService
) {
    fun registerUser(email: String, password: String) {
        userRepos.saveUser(email, password)
        notificationService.send("Registration done", "apurohit@bosleo.com", "to-non_reply@cognizant.com")
    }
}

