package com.example.fyp.database.mechanic.enity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class UserEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "user_name") var user_name: String,
    @ColumnInfo(name = "email") var email: String,
    @ColumnInfo(name = "password") var password: String,
    @ColumnInfo(name = "mobile") var mobile: String,
    @ColumnInfo(name = "city") var city: String,
    @ColumnInfo(name = "userType") var userType: String

)