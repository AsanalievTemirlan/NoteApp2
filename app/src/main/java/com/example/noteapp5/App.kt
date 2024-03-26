package com.example.noteapp5

import android.app.Application
import androidx.room.Room
import com.example.noteapp5.data.db.AppDataBase
import com.example.noteapp5.unitls.PreferenceHelper

class App: Application() {

    companion object{
        var appDataBase: AppDataBase? = null
    }
    override fun onCreate(){
        super.onCreate()
        val sharedPreferences = PreferenceHelper
        sharedPreferences.unit(this)
        getInstance()

    }

    fun getInstance(): AppDataBase? {
        if (appDataBase == null) {
            appDataBase = applicationContext?.let {
                Room.databaseBuilder(
                    it,
                    AppDataBase::class.java,
                    "note.db"
                ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
            }
        }
        return appDataBase

    }
}