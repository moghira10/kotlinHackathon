package com.example.bhukkd

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_order_page.view.*

class OrderPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_order_page)
        var ll :LinearLayout= findViewById(R.id.mainLL)

        data class FoodItem (val name: String, val qty: Int, var price: Int)
        var foodItems :Array<FoodItem> = arrayOf(FoodItem("Pizza",20, 20), FoodItem("Cheesy Fries", 10, 10))

        ll.removeAllViews()
        var total=0;
        for (item in foodItems) {

            var v: View = LayoutInflater.from(this).inflate(R.layout.item, ll, false)

            var itemName = v.findViewById<TextView>(R.id.itName);
            itemName.setText("${item.name}   (Qty: ${item.qty})");

            var itemPrice = v.findViewById<TextView>(R.id.itPrice);
            itemPrice.setText("Rs."+item.qty*item.price);

            total += item.qty*item.price;

            ll.addView(v);
        }
        var totalView: TextView = findViewById(R.id.total);
        totalView.setText("Total : Rs."+total);
    }
}
