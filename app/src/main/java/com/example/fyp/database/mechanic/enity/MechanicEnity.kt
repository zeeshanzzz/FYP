package com.example.fyp.database.mechanic.enity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mechanic_business")
data class MechanicEnity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "email") var email: String,
    @ColumnInfo(name = "worktype") var worktype: String,
    @ColumnInfo(name = "city") var city: String,
    @ColumnInfo(name = "address") var address: String,
    @ColumnInfo(name = "license") var license: String,
    @ColumnInfo(name = "approve_status") var approve_status: String

)
