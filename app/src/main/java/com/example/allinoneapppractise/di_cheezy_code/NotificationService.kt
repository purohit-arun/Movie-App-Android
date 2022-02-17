package com.example.allinoneapppractise.di_cheezy_code

import android.util.Log
import javax.inject.Inject

interface NotificationService {
    fun send(body: String, to: String, from: String)
}

class EmailService @Inject constructor() : NotificationService {
    override fun send(body: String, to: String, from: String) {
        Log.i("MYTAG", "Email sent")
        Log.i("MYTAG", "$body sended to $to from mail address $from")
    }
}

class MessageService constructor(private val retryCount: Int) : NotificationService {
    override fun send(body: String, to: String, from: String) {
        Log.i("MYTAG", "Message send - Retry Count $retryCount")
        Log.i("MYTAG", "$body sended to $to from mail address $from")
    }
}