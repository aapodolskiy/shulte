package com.example.alexander.shulte02

import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_settings.*
import android.os.Bundle
import android.content.Intent



class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_settings)

        settingsActivityMenuButton.setOnClickListener{
            val mainActivity = Intent(this, MainActivity::class.java)
            startActivity(mainActivity)
        }
    }
}
