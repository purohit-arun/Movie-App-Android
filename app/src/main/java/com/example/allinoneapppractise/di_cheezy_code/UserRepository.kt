package com.example.allinoneapppractise.di_cheezy_code

import android.util.Log
import javax.inject.Inject

interface UserRepository {
    fun saveUser(email: String, password: String)
}

class SQLUserRepository @Inject constructor() : UserRepository {
    override fun saveUser(email: String, password: String) {
        Log.i("MYTAG", "user saved with the address $email and $password")
        Log.i("MYTAG", "User registered in Local Database")
    }
}

class FireBaseUserRepository : UserRepository {
    override fun saveUser(email: String, password: String) {
        Log.i("MYTAG", "user saved with the address $email and $password")
        Log.i("MYTAG", "User saved in Firebase")
    }
}