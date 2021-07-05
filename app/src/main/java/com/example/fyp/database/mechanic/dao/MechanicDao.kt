package com.example.fyp.database.mechanic.dao

import androidx.room.*
import com.example.fyp.database.mechanic.enity.MechanicEnity

@Dao
interface MechanicDao {
    @Query("SELECT * FROM mechanic_business")
    fun getAll(): List<MechanicEnity>

    @Query("SELECT * FROM mechanic_business WHERE approve_status LIKE :approve_status")
    fun findByTitle(approve_status: String): List<MechanicEnity>

    @Insert
    fun insertAll(vararg todo: MechanicEnity)

    @Delete
    fun delete(todo: MechanicEnity)

    @Update
    fun updateTodo(vararg todos: MechanicEnity)

    @Query("UPDATE mechanic_business SET approve_status=:approve_status WHERE email = :email")
    fun update(approve_status: String, email: String)
}