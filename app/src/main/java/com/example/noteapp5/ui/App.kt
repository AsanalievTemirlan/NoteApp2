package com.example.noteapp5.ui

import android.app.Application
import com.example.noteapp5.ui.unitls.PreferenceHelper

class App: Application() {

    override fun onCreate(){
        super.onCreate()
        val sharedPreferences = PreferenceHelper
        sharedPreferences.unit(this)
    }
}