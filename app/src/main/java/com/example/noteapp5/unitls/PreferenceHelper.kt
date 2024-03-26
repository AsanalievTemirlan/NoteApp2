package com.example.noteapp5.unitls

import android.content.Context
import android.content.SharedPreferences


object PreferenceHelper {

    private lateinit var sharedPreferences: SharedPreferences

    fun unit(context: Context) {
        sharedPreferences = context.getSharedPreferences("shared", Context.MODE_PRIVATE)
    }

    fun onShowed() {
        sharedPreferences.edit().putBoolean(SHOWED, true).apply()
    }
    fun  isShowed():Boolean{
       return sharedPreferences.getBoolean(SHOWED, false)
    }

    var isOnBoardShown: Boolean
        get() = sharedPreferences.getBoolean("board", false)
        set(value) = sharedPreferences.edit().putBoolean("board", value).apply()


    const val SHOWED = "SHOWED"

}
