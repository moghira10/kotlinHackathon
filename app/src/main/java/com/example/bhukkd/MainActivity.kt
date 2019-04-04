package com.example.bhukkd

import android.animation.Animator
import android.app.ActionBar
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        object : CountDownTimer(3000, 1000) {
            override fun onFinish() {
                bookITextView.visibility = View.GONE
                loadingProgressBar.visibility = View.GONE
                rootView.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.colorSplashText5))
                bookIconImageView.setImageResource(R.drawable.kg)
                var lp :ViewGroup.LayoutParams = bookIconImageView.layoutParams
                lp.height = 150
                lp.width = 150
                bookIconImageView.layoutParams = lp
                startAnimation()
            }

            override fun onTick(p0: Long) {}
        }.start()


        val btn_submit: Button = findViewById(R.id.loginButton)
//        set on-click listener
        btn_submit.setOnClickListener {
            var et_user_name: TextView = findViewById<TextView>(R.id.emailEditText)
            var et_password: TextView = findViewById<TextView>(R.id.passwordEditText)
            val user_name = et_user_name.text.toString()
            val password = et_password.text.toString()
            if(user_name.equals("Abc") && password.equals("Abcd")) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                val i = Intent(this@MainActivity, Discovery::class.java)
                startActivity(i)
            }
            else {
                Toast.makeText(this, "Please enter valid Username and Password", Toast.LENGTH_SHORT).show()
            }


        }
    }

    private fun startAnimation() {
        bookIconImageView.animate().apply {
            x(50f)
            y(100f)
            duration = 1000
        }.setListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator?) {

            }

            override fun onAnimationEnd(p0: Animator?) {
                afterAnimationView.visibility = VISIBLE
            }

            override fun onAnimationCancel(p0: Animator?) {

            }

            override fun onAnimationStart(p0: Animator?) {

            }
        })
    }



}

