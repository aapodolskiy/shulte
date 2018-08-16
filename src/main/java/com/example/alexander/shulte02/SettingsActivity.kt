package com.example.alexander.shulte02

import android.content.Context
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_settings.*
import android.os.Bundle
import android.content.Intent



class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_settings)

        val myPreferences = getSharedPreferences("myPreferences", Context.MODE_PRIVATE)

        if (myPreferences.contains("timer")) {
            timerSwitch.isChecked = myPreferences.getBoolean("timer", false)
        }

        if (myPreferences.contains("sound")) {
            soundSwitch.isChecked = myPreferences.getBoolean("sound", false)
        }

        if (myPreferences.contains("other")) {
            otherSwitch.isChecked = myPreferences.getBoolean("other", false)
        }

        timerSwitch.setOnClickListener{
            val editor = myPreferences.edit()
            editor.putBoolean("timer", timerSwitch.isChecked)
            editor.apply()
        }

        soundSwitch.setOnClickListener{
            val editor = myPreferences.edit()
            editor.putBoolean("sound", soundSwitch.isChecked)
            editor.apply()
        }

        otherSwitch.setOnClickListener{
            val editor = myPreferences.edit()
            editor.putBoolean("other", otherSwitch.isChecked)
            editor.apply()
        }

        settingsActivityMenuButton.setOnClickListener{
            val mainActivity = Intent(this, MainActivity::class.java)
            startActivity(mainActivity)
        }
    }
}
