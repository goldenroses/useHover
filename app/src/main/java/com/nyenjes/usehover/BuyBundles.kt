package com.nyenjes.usehover

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class BuyBundles: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.success_page)



        val data = intent.getStringExtra("bundledata")
        val data02 = intent.getStringExtra("bundledata")


    }
}
