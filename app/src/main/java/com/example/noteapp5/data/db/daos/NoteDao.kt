package com.example.noteapp5.data.db.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.noteapp5.data.model.NoteModel

@Dao
interface NoteDao {

    @Query("SELECT * FROM noteModel")
    fun getAllNotes(): List<NoteModel>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(noteModel: NoteModel)

    @Delete
    fun deleteNote(noteModel: NoteModel)
}