package com.example.noteapp5.ui.unitls

import android.content.Context
import android.content.SharedPreferences


class PreferenceHelper {

    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(
            "shared",
            Context.MODE_PRIVATE
        )
    }

    var isOnBoardShow: Boolean
        get() {
            return if (::sharedPreferences.isInitialized) {
                sharedPreferences.getBoolean("board", false)
            } else {
                false
            }
        }
        set(value) {
            sharedPreferences.edit().putBoolean("board", value).apply()
        }
}
