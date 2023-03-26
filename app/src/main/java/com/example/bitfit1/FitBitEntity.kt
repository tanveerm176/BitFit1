package com.example.bitfit1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise_table")

data class Exercise (
    @ColumnInfo(name = "weekday") val weekday: String?,
    @ColumnInfo(name="exercise") val exercise : String?,
    @ColumnInfo(name = "duration") val calories: String?,
    @PrimaryKey(autoGenerate = true) val id: Long=0
        )