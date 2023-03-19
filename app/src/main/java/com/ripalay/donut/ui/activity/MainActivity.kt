package com.ripalay.donut.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.ripalay.donut.R
import com.ripalay.donut.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavController()
        initDestination()
    }

    private fun initDestination() {
        navController.addOnDestinationChangedListener { navController, destination, arguments ->
            if ((destination.id == R.id.startFragment)||
                (destination.id == R.id.registerFragment) ||
                (destination.id == R.id.signFragment)){
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                //window.statusBarColor = ContextCompat.getColor(this, R.color.fon_top)
                binding.cardNav.visibility = View.GONE
            } else {
                actionBar?.show()
                binding.cardNav.visibility = View.VISIBLE
                window.statusBarColor = ContextCompat.getColor(this, R.color.fon_top)
            }
            if (destination.id == R.id.tasksFragment){
                binding.navView.menu.getItem(0).isChecked = true
            }
        }
    }
    private fun initNavController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.navView, navController)
        binding.navView.menu.getItem(1).isChecked = true
    }
}