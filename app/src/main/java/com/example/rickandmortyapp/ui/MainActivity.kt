package com.example.rickandmortyapp.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.rickandmortyapp.R

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpActionBar()
    }

    override fun onSupportNavigateUp() = navController.navigateUp() || super.onSupportNavigateUp()


    private fun setUpActionBar() {
        val navHost = supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        navController = navHost.navController
        setupActionBarWithNavController(navController)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.BLACK))
    }

}