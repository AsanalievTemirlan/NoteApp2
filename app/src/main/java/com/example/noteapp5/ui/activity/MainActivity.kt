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
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment

       navController = navHostFragment.navController


        if (PreferenceHelper.isOnBoardShown){
            navController.navigate(R.id.onBoardFragment)
            PreferenceHelper.isOnBoardShown = false
        }else{
            navController.navigate(R.id.noteFragment)
        }



    }
}
