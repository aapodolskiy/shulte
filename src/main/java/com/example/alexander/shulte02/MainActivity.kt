package com.example.alexander.shulte02

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        mainActivityPlayButton.setOnClickListener {
            val gameActivity = Intent(this, GameActivity::class.java)
            startActivity(gameActivity)
        }

        mainActivitySettingsButton.setOnClickListener {
            val settingsActivity = Intent(this, SettingsActivity::class.java)
            startActivity(settingsActivity)
        }
    }

}
