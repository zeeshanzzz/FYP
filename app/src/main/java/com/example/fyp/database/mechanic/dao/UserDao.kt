package com.example.fyp.database.mechanic.dao

import androidx.room.*
import com.example.fyp.database.mechanic.enity.MechanicFeedBackEntity
import com.example.fyp.database.mechanic.enity.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM Users")
    fun getAll(): List<UserEntity>

    @Query("SELECT * FROM Users WHERE user_name LIKE :user_name")
    fun findByTitle(user_name: String): UserEntity

    @Insert
    fun insertAll(vararg todo: UserEntity)

    @Delete
    fun delete(todo: UserEntity)

    @Update
    fun updateTodo(vararg todos: UserEntity)
}