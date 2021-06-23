package com.example.fyp.database.mechanic.dao

import androidx.room.*
import com.example.fyp.database.mechanic.enity.MechanicEnity
import com.example.fyp.database.mechanic.enity.MechanicFeedBackEntity

@Dao
interface MechanicFeedBack {
    @Query("SELECT * FROM mechanic_feedback")
    fun getAll(): List<MechanicFeedBackEntity>

    @Query("SELECT * FROM mechanic_feedback WHERE user_name LIKE :title")
    fun findByTitle(title: String): MechanicFeedBackEntity

    @Insert
    fun insertAll(vararg todo: MechanicFeedBackEntity)

    @Delete
    fun delete(todo: MechanicFeedBackEntity)

    @Update
    fun updateTodo(vararg todos: MechanicFeedBackEntity)
}