package com.example.fyp.database.mechanic.dao

import androidx.room.*
import com.example.fyp.database.mechanic.enity.MechanicFeedBackEntity
import com.example.fyp.database.mechanic.enity.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM Users")
    fun getAll(): List<UserEntity>

    @Query("SELECT * FROM Users WHERE email LIKE :email")
    fun findByEmail(email: String): UserEntity

    @Query("SELECT * FROM Users WHERE userType LIKE :userType")
    fun findByUserType(userType: String): List<UserEntity>


    @Insert
    fun insertAll(vararg todo: UserEntity)

    @Delete
    fun delete(todo: UserEntity)

    @Update
    fun updateTodo(vararg todos: UserEntity)
}