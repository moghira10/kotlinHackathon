package com.example.bhukkd

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_order_page.view.*
import org.w3c.dom.Text

class OrderPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.activity_order_page)

        this.supportActionBar?.title = "Review Your Order"

        var ll: LinearLayout = findViewById(R.id.mainLL)

        data class FoodItem(val name: String, val qty: Int, var price: Int)

        var foodItems: Array<FoodItem> = arrayOf(FoodItem("Pizza", 20, 20), FoodItem("Cheesy Fries", 10, 10))

        ll.removeAllViews()
        var total = 0;
        for (item in foodItems) {

            var v: View = LayoutInflater.from(this).inflate(R.layout.item, ll, false)

            var itemName = v.findViewById<TextView>(R.id.itName);
            itemName.setText("${item.name}   (Qty: ${item.qty})");

            var itemPrice = v.findViewById<TextView>(R.id.itPrice);
            itemPrice.setText("Rs." + item.qty * item.price);

            total += item.qty * item.price;

            ll.addView(v);
        }
        var totalView: TextView = findViewById(R.id.total);
        totalView.setText("Total : Rs." + total);

        val checkout: TextView = findViewById(R.id.checkout)

        checkout.setOnClickListener {
            val i = Intent(this@OrderPage, OrderPlaced::class.java)
            startActivity(i)
        }
    }
}
