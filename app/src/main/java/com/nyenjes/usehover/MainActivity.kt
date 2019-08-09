package com.nyenjes.usehover

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hover.sdk.api.Hover
import com.nyenjes.usehover.adapters.CardRecyclerAdapter
import com.nyenjes.usehover.providers.CardDataProvider
import kotlinx.android.synthetic.main.offer_view.*

class MainActivity : AppCompatActivity() {

    private var recycler: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        Hover.initialize(this)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Welcome"
        recycler = findViewById(R.id.recycler )

        recycler!!.layoutManager = LinearLayoutManager(this)

        displayMainCards()

    }

    //Diaplays bank + MNO cards
    private fun displayMainCards() {

        recycler!!.adapter = CardRecyclerAdapter(CardDataProvider.getAllAirtimeCards(), this)
    }

    //Diaplays utiity cards
    private fun displayUtilityCards() {

        recycler!!.adapter = CardRecyclerAdapter(CardDataProvider.getAllUtilityCards(), this)
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                displayMainCards()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                displayUtilityCards()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
}
