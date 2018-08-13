package com.example.alexander.shulte02

import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_finish.*
import android.os.Bundle
import android.content.Intent



class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_finish)

        //val finishTextString = getString(R.string.finishText)
        //finishText.text = finishTextString.replace("{finishTime}", finishTimeString)

        startAgainButton.setOnClickListener{
            val mainActivity = Intent(this, GameActivity::class.java)
            startActivity(mainActivity)
        }

        goToMenuButton.setOnClickListener{
            val mainActivity = Intent(this, MenuActivity::class.java)
            startActivity(mainActivity)
        }

    }
}
