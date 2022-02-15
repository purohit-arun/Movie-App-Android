package kotlin_design_patterns.di

import javax.inject.Inject

class EmailService @Inject constructor() {
    fun send(body: String, to: String, from: String) {
        println("$body sended to $to from mail address $from")
        println("Email sent")
    }

}

class UserRepository @Inject constructor() {
    fun saveUser(email: String, password: String) {
        println("user saved with the address $email and $password")
        println("User registered")
    }
}

class UserRegistrationService @Inject constructor(
    private val userRepos: UserRepository,
    private val emailService: EmailService
) {

    fun registerUser(email: String, password: String) {
        userRepos.saveUser(email, password)
        emailService.send(
            "Registration done", "apurohit@bosleo.com", "to-non_reply@cognizant.com"
        )
    }
}

