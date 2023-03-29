package com.example.bitfit1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise_table")

data class ExerciseEntity (
    @PrimaryKey(autoGenerate = true) val id: Long=0,
    @ColumnInfo(name = "weekday") val weekday: String?,
    @ColumnInfo(name="title") val title : String?,
    @ColumnInfo(name = "duration") val duration: String?
)