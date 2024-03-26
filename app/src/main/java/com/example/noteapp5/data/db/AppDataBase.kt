package com.example.noteapp5.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.noteapp5.data.db.daos.NoteDao
import com.example.noteapp5.data.model.NoteModel

@Database(entities = [NoteModel::class], version = 1)

abstract class AppDataBase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

}