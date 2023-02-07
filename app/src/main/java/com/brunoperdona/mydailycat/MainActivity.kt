package com.brunoperdona.mydailycat

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.brunoperdona.mydailycat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Fix Bottom Navigation Overlay
        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.menu[2].isEnabled = false

        val navView: BottomNavigationView = binding.bottomNavigationView


        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration(
            setOf(
                R.id.navigation_timeline, R.id.navigation_calendar, R.id.navigation_tree, R.id.navigation_statistics
            )
        )
        navView.setupWithNavController(navController)
    }
}