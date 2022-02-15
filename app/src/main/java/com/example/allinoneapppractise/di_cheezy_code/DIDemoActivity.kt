package com.example.allinoneapppractise.di_cheezy_code

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.allinoneapppractise.R
import kotlin_design_patterns.di.DaggerUserRegistrationComponent
import kotlin_design_patterns.di.EmailService
import kotlin_design_patterns.di.UserRegistrationService
import javax.inject.Inject

class DIDemoActivity : AppCompatActivity() {

    @Inject
    lateinit var userRegistrationService: UserRegistrationService

    @Inject
    lateinit var emailService: EmailService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_di_demo)

        val component = DaggerUserRegistrationComponent.builder().build()
        component.inject(this)
        userRegistrationService.registerUser("apurohit@bosleo.com", "Arun@123")
    }
}