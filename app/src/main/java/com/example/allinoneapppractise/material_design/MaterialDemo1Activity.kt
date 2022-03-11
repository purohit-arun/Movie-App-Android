package com.example.allinoneapppractise.material_design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.allinoneapppractise.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MaterialDemo1Activity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private val gameFragment = GameFragment()
    private val shopFragment = ShopFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_demo1)
        bottomNavigationView = findViewById(R.id.bottom_navigation)
        replaceFramgment(shopFragment)
        bottomNavigationView.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.page_1 -> replaceFramgment(shopFragment)
                R.id.page_2 -> replaceFramgment(gameFragment)
            }
            true
        }
    }

    private fun replaceFramgment(fragment: Fragment) {
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_material, fragment)
                .commit()
        }
    }
}