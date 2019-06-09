package com.example.laboultimo.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Coincidencia::class], version = 1, exportSchema = false)
 abstract class RoomDB2 : RoomDatabase() {

    abstract fun repoDao():MovieDao

    companion object {
        @Volatile
        private var INSTANCE: RoomDB2? = null

        fun getInstance(
            context: Context
        ): RoomDB2 {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room
                    .databaseBuilder(context, RoomDB2::class.java, "Repo_Database")
                    .build()
                INSTANCE=instance
                return instance
            }

        }

    }

}