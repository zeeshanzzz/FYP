package com.example.fyp.database.mechanic.dao

import androidx.room.*
import com.example.fyp.database.mechanic.enity.MechanicEnity

@Dao
interface MechanicDao {
    @Query("SELECT * FROM mechanic_business")
    fun getAll(): List<MechanicEnity>

    @Query("SELECT * FROM mechanic_business WHERE name LIKE :title")
    fun findByTitle(title: String): MechanicEnity

    @Insert
    fun insertAll(vararg todo: MechanicEnity)

    @Delete
    fun delete(todo: MechanicEnity)

    @Update
    fun updateTodo(vararg todos: MechanicEnity)
}