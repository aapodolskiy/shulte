package com.example.alexander.shulte02

import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_menu.*
import android.os.Bundle
import android.content.Intent



class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_menu)

        backToMainPageButton.setOnClickListener{
            val mainActivity = Intent(this, MainActivity::class.java)
            startActivity(mainActivity)
        }
    }
}
