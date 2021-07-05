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

@Database(entities = [MechanicEnity::class, MechanicFeedBackEntity::class, UserEntity::class], version = 2,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun mechanicDao(): MechanicDao
    abstract fun mechanicFeedbackDao(): MechanicFeedBack
    abstract fun userDao(): UserDao
    companion object {
//        @Volatile private var instance: AppDatabase? = null
//        private val LOCK = Any()

//        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
//            instance ?: buildDatabase(context).also { instance = it}
//        }
private var userDB: AppDatabase? = null
        fun getInstance(context: Context?): AppDatabase? {
            if (null == userDB) {
                userDB = buildDatabaseInstance(context!!)
            }
            return userDB
        }
        fun buildDatabaseInstance(context: Context): AppDatabase {
            return Room.databaseBuilder(context,
                    AppDatabase::class.java,
                    "FYP.db")
                .fallbackToDestructiveMigration()
                    .build()
        }
    }



    open fun cleanUp() {
        userDB = null
    }
}

