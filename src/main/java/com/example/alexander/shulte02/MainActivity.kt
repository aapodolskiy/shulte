package com.example.alexander.shulte02

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_start.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_start)

        startButton.setOnClickListener {
            val gameActivity = Intent(this, GameActivity::class.java)
            startActivity(gameActivity)
        }
    }
/*
    private fun playClassicGame() {
        setContentView(R.layout.activity_main)

        val randomizedArray = (1..25).shuffled()

        val cells = listOf(
                view_s01,
                view_s02,
                view_s03,
                view_s04,
                view_s05,
                view_s06,
                view_s07,
                view_s08,
                view_s09,
                view_s10,
                view_s11,
                view_s12,
                view_s13,
                view_s14,
                view_s15,
                view_s16,
                view_s17,
                view_s18,
                view_s19,
                view_s20,
                view_s21,
                view_s22,
                view_s23,
                view_s24,
                view_s25
        )

        val startTime = Date().time

        var nextNumber = 1

        print(nextNumber)

        currentNumberToFind.text = nextNumber.toString()

        for (i in 0..24) {
            cells[i].text = randomizedArray[i].toString()
            cells[i].setOnClickListener {
                if (nextNumber == randomizedArray[i]) {
                    nextNumber++
                    if (nextNumber == 26) {
                        val finishTime = Date().time
                        val totalTime = (finishTime - startTime) / 1000.0

                        finishPageListeners(totalTime.toString())
                    } else {
                        currentNumberToFind.text = nextNumber.toString()
                    }
                }
            }
        }
    }

    private fun startPageListeners() {
        setContentView(R.layout.activity_start)

        startButton.setOnClickListener {
            playClassicGame()
        }
    }

    private fun finishPageListeners(finishTimeString: String) {
        setContentView(R.layout.activity_finish)

        val finishTextString = getString(R.string.finishText)
        finishText.text = finishTextString.replace("{finishTime}", finishTimeString)

        startAgainButton.setOnClickListener{
            playClassicGame()
        }

        goToMenuButton.setOnClickListener{
            startPageListeners()
        }
    }
*/
}