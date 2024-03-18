package com.example.noteapp5.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.noteapp5.R
import com.example.noteapp5.ui.App
import com.example.noteapp5.ui.unitls.PreferenceHelper

class MainActivity : AppCompatActivity() {
    private lateinit var navController : NavController
    private lateinit var preferenceHelper: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment

        navController = navHostFragment.navController

        preferenceHelper = PreferenceHelper()
        preferenceHelper.init(applicationContext)

        if (!preferenceHelper.isOnBoardShow) {
            navController.navigate(R.id.onBoardFragment)
            preferenceHelper.isOnBoardShow = true
        } else {
            navController.navigate(R.id.noteFragment)

        }
    }
}
