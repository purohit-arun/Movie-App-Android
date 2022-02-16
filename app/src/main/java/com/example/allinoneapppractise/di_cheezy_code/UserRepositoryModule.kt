package com.example.allinoneapppractise.di_cheezy_code

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class UserRepositoryModule {
    /*@Provides
    fun getFireBaseRepository(): UserRepository {
        return FireBaseUserRepository()
    }*/

    /*@Provides
    fun getSQLRepository(sqlUserRepository: SQLUserRepository): UserRepository {
        return SQLUserRepository()
    }
    //below converted to @Binds as dagger can call constructor object for this
    //sqlUserRepository
    */
    @Binds
    abstract fun getBindSQLRepository(sqlUserRepository: SQLUserRepository): UserRepository

}