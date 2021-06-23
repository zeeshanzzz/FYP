package com.example.fyp.database.mechanic

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fyp.database.mechanic.dao.MechanicDao
import com.example.fyp.database.mechanic.dao.MechanicFeedBack
import com.example.fyp.database.mechanic.dao.UserDao
import com.example.fyp.database.mechanic.enity.MechanicEnity
import com.example.fyp.database.mechanic.enity.MechanicFeedBackEntity
import com.example.fyp.database.mechanic.enity.UserEntity

@Database(entities = arrayOf(MechanicEnity::class,MechanicFeedBackEntity::class, UserEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun mechanicDao(): MechanicDao
    abstract fun mechanicFeedbackDao(): MechanicFeedBack
    abstract fun userDao(): UserDao
    companion object {
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            AppDatabase::class.java, "todo-list.db")
            .build()
    }
}

