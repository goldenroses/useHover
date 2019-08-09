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

class OfferPageActivity: AppCompatActivity() {
    val bundleOptionsList = arrayOf("Bundle type","Daily bundle", "7 day bundle", "30 day Bundle")
    val bundleFrequencyList = arrayOf("Bundle Frequency","Once", "Auto-Renew")
    val bundlePaymentSourceList = arrayOf("Buy From?","Airtime", "MPESA")

    private var bundleOption: String? = null
    private var bundleAmount: String? = null
    private var bundleFrequency: String? = null
    private var bundlePaymentSource: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.offer_view)

        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Safaricom Offers"

        setSpinners(spinnerBundleOption, bundleOptionsList)
        setSpinners(spinnerBundleFrequency, bundleFrequencyList)
        setSpinners(spinnerBundleSource, bundlePaymentSourceList)
    }

    fun setSpinners(spinnerType: Spinner, data: Array<String>) {
        val bundleAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data)
        bundleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerType.setAdapter(bundleAdapter)
        spinnerType.setSelection(0)
    }


    fun buyAirtime(view: View) {
        val intent = Intent(this, BuyBundles::class.java)
        bundleOption = (spinnerBundleOption.selectedItemId + 1).toString()
        bundleAmount = bundlePrice.text.toString()
        bundleFrequency = spinnerBundleFrequency.selectedItemId.toString()
        bundlePaymentSource = spinnerBundleSource.selectedItemId.toString()

        val i =  HoverParameters.Builder(this)
            .request("5963ca2d")
            .extra("bundleOption", bundleOption)
            .extra("bundleAmount", bundleAmount)
            .extra("bundleFrequency", bundleFrequency)
            .extra("bundlePaymentSource", bundlePaymentSource)
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
