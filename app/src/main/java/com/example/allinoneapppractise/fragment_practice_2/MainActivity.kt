package com.example.allinoneapppractise.fragment_practice_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.allinoneapppractise.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val fragmentById = supportFragmentManager.findFragmentById(R.id.tv_in_fragment)
        val fragmentByTag = supportFragmentManager.findFragmentByTag("MyflFragment")
        if (savedInstanceState == null) {
            val bundle = bundleOf("some_int" to 0)
//            supportFragmentManager.commit {
//                setReorderingAllowed(true)
//                add<BlankFragment>(R.id.fragment_container_view_inside_activity_4, args = bundle)
//            }
            supportFragmentManager.beginTransaction()
                .replace<BlankFragment>(R.id.fragment_container_view_inside_activity_4,tag = "myflFragment")
                .addToBackStack("Fragment Blank")
                .commit()

        }


    }
}