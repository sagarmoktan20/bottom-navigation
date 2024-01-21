package com.example.bottom_nvigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView=findViewById<BottomNavigationView>(R.id.bottomnav)
        //by default home fragment should visible
        replacewithFragment(Home())

        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.item1->replacewithFragment(Home())
                R.id.item2->replacewithFragment(Search())
                R.id.item3->replacewithFragment(Profile())
            else -> {

            }
            }
            true
        }
    }

    private fun replacewithFragment(fragment: Fragment) {

        val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame,fragment)
        fragmentTransaction.commit()
    }
}