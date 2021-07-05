package com.example.fyp.database.mechanic.enity

import android.text.Editable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "mechanic_feedback")
data class MechanicFeedBackEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "user_name") var user_name: String,
    @ColumnInfo(name = "date") var date: String,
    @ColumnInfo(name = "feedback") var feedback: String
)

