package com.example.fyp.database.mechanic.dao

import androidx.room.*
import com.example.fyp.database.mechanic.enity.MechanicEnity

@Dao
interface MechanicDao {
    @Query("SELECT * FROM mechanic_business")
    fun getAll(): List<MechanicEnity>

    @Query("SELECT * FROM mechanic_business WHERE name LIKE :name")
    fun findByTitle(name: String): MechanicEnity

    @Insert
    fun insertAll(vararg todo: MechanicEnity)

    @Delete
    fun delete(todo: MechanicEnity)

    @Update
    fun updateTodo(vararg todos: MechanicEnity)

    @Query("UPDATE mechanic_business SET approve_status=:approve_status WHERE name = :name")
    fun update(approve_status: String, name: String)
}