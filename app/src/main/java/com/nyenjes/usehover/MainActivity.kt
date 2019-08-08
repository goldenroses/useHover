package com.nyenjes.usehover

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import com.hover.sdk.api.Hover

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        Hover.initialize(this)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

//        displayMainCards()
        displayOFfers()

    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                displayOFfers()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    fun displayOFfers() {
        val intent = Intent(this, SafaricomOfferPageActivity::class.java)
        startActivity(intent)
    }

    companion object {
        const val SUCCESS_STATUS = "0"
    }
}
