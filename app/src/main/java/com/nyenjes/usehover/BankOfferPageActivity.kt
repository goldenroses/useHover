package com.nyenjes.usehover

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hover.sdk.api.HoverParameters
import kotlinx.android.synthetic.main.offer_view.*

class BankOfferPageActivity: AppCompatActivity() {

    private var airtimeAmount: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bank_offer_view)

        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Bank Airtime Offers"

    }

    fun buyBankAirtime(view: View) {
        airtimeAmount = bundlePrice.text.toString()

        val i =  HoverParameters.Builder(this)
            .request("5963ca2d")
            .extra("airtimeAmount", airtimeAmount)
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
