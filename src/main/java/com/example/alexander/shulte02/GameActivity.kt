package com.example.alexander.shulte02

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game.*
import android.app.Activity
import java.io.File
import java.io.OutputStreamWriter
import java.io.IOException
import java.util.Date

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_game)

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

        val myPreferences = getSharedPreferences("myPreferences", Context.MODE_PRIVATE)

        var showText = true
        if (myPreferences.contains("other")) {
            showText = myPreferences.getBoolean("other", true)
        }
        else {
            val editor = myPreferences.edit()
            editor.putBoolean("other", showText)
            editor.apply()
        }

        val currentNumberToFindString = getString(R.string.gameActivityNumberToFind)
        if (showText) {
            currentNumberToFind.text = currentNumberToFindString.replace("{nextNumber}", nextNumber.toString())
        }

        for (i in 0..24) {
            cells[i].text = randomizedArray[i].toString()
            cells[i].setOnClickListener {
                if (nextNumber == randomizedArray[i]) {
                    nextNumber++
                    if (nextNumber == 26) {
                        val finishTime = Date().time
                        val totalTime = ((finishTime - startTime) / 10 ) / 100.0

                        val extras = Bundle()
                        extras.putString("finishTime", totalTime.toString())

                        val fileName = "shulteResults.txt"
                        try {
                            val fileWriter = OutputStreamWriter(openFileOutput(fileName, Activity.MODE_APPEND))
                            fileWriter.append(totalTime.toString() + "\n")
                            fileWriter.flush()
                            fileWriter.close()
                        }
                        catch (e: IOException) {
                        }

                        val finishActivity = Intent(this, FinishActivity::class.java)
                        finishActivity.putExtras(extras)
                        startActivity(finishActivity)

                    } else {
                        if (showText) {
                            currentNumberToFind.text = currentNumberToFindString.replace("{nextNumber}", nextNumber.toString())
                        }
                    }
                }
            }
        }

    }

}
