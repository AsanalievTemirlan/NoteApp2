package com.example.noteapp5.data.model

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.noteapp5.R
@Entity(tableName = "noteModel")
data class NoteModel(
    val title: String,
    val content: String,
    val color: Int = Color.BLACK,
    val time: String,
    val date: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

