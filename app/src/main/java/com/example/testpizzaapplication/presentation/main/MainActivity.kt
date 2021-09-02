package com.example.testpizzaapplication.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.testpizzaapplication.R
import com.example.testpizzaapplication.databinding.ActivityMainBinding
import com.example.testpizzaapplication.presentation.bucket.BucketFragment
import com.example.testpizzaapplication.presentation.menu.MenuFragment
import com.example.testpizzaapplication.presentation.profile.ProfileFragment

class MainActivity : AppCompatActivity() {

    private val viewBinding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, MenuFragment())
            .commit()
        with(viewBinding) {
            bottomNavigation.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu -> replaceFragment(MenuFragment())
                    R.id.profile -> replaceFragment(ProfileFragment())
                    R.id.bucket -> replaceFragment(BucketFragment())
                }
                return@setOnItemSelectedListener true
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }
}
