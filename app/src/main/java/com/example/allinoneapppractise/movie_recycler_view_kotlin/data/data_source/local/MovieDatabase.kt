package com.example.allinoneapppractise.movie_recycler_view_kotlin.data.data_source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.models.local.Movie
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import javax.inject.Singleton

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract val movieDAO: MovieDao

    /*companion object {
        @Volatile
        private var INSTANCE: MovieDatabase? = null

        //        val re = ReentrantLock()
        private val mutexLock = Mutex()


        fun getInstance(context: Context): MovieDatabase? {
            return runBlocking {
                mutexLock.lock(this)
                try {
                    var instance = INSTANCE
                    if (instance == null) {

                        instance =
                    }
                    instance

                } catch (e: Exception) {
                    print(e.printStackTrace())
                    null
                } finally {
                    mutexLock.unlock()
                }
            }
        }
    }*/
}