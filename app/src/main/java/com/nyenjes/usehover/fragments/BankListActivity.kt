package com.nyenjes.usehover.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nyenjes.usehover.R
import com.nyenjes.usehover.adapters.CardRecyclerAdapter
import com.nyenjes.usehover.providers.CardDataProvider
import kotlinx.android.synthetic.main.offer_view.*

class BankListActivity : AppCompatActivity() {
    private var adapter: CardRecyclerAdapter? = CardRecyclerAdapter(null, this)
    private var recycler: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_bank_list)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Current Banks"

        recycler = findViewById(R.id.recycler_bank )

        recycler!!.layoutManager = LinearLayoutManager(this)

        recycler!!.adapter = CardRecyclerAdapter(CardDataProvider.getBanksCards(), this)

    }

}
