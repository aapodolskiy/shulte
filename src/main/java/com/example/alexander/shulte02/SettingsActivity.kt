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

        val timerSwitchDefault = false
        if (myPreferences.contains("timer")) {
            timerSwitch.isChecked = myPreferences.getBoolean("timer", timerSwitchDefault)
        }
        else {
            val editor = myPreferences.edit()
            editor.putBoolean("timer", timerSwitchDefault)
            editor.apply()
            timerSwitch.isChecked = timerSwitchDefault
        }

        val soundSwitchDefault = false
        if (myPreferences.contains("sound")) {
            soundSwitch.isChecked = myPreferences.getBoolean("sound", soundSwitchDefault)
        }
        else {
            val editor = myPreferences.edit()
            editor.putBoolean("sound", soundSwitchDefault)
            editor.apply()
            soundSwitch.isChecked = soundSwitchDefault
        }

        val otherSwitchDefault = true
        if (myPreferences.contains("other")) {
            otherSwitch.isChecked = myPreferences.getBoolean("other", otherSwitchDefault)
        }
        else {
            val editor = myPreferences.edit()
            editor.putBoolean("other", otherSwitchDefault)
            editor.apply()
            otherSwitch.isChecked = otherSwitchDefault
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
