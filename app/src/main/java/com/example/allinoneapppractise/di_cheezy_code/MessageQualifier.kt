package com.example.allinoneapppractise.di_cheezy_code

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class MessageQualifier {
}

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class EmailQualifier {
}