package com.example.bhukkd

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class OrderPlaced : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_placed)
        this.supportActionBar?.title = "Order Placed"

    }
}
