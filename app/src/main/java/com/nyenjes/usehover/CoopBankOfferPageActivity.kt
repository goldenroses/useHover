package com.nyenjes.usehover

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hover.sdk.api.HoverParameters
import com.nyenjes.usehover.adapters.CardRecyclerAdapter
import kotlinx.android.synthetic.main.offer_view.*
import android.widget.Toast
import android.app.Activity

class CoopBankOfferPageActivity: AppCompatActivity() {
    private var adapter: CardRecyclerAdapter? = CardRecyclerAdapter(null)
    private var recycler: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.offer_view)

        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Welcome"
        recycler = findViewById(R.id.recycler )
        recycler!!.layoutManager = LinearLayoutManager(this)
        recycler!!.adapter = adapter

    }

    fun buyBundle5Bob(view: View) {
        val intent = Intent(this, BuyBundles::class.java)

        val i =  HoverParameters.Builder(this)
            .request("5963ca2d")
            .buildIntent()

        startActivityForResult(i, 0)
//        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
            val sessionTextArr = data!!.getStringArrayExtra("ussd_messages")
            val uuid = data.getStringExtra("uuid")
        } else if (requestCode == 0 && resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(this, "Error: " + data!!.getStringExtra("error")!!, Toast.LENGTH_LONG).show()
        }
    }
    //Transaction receiver - Receives the messages - broadcasts
}
