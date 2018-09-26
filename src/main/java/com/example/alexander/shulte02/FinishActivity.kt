package com.example.alexander.shulte02

import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_finish.*
import android.os.Bundle
import android.content.Intent
import java.io.InputStreamReader
import java.io.BufferedReader
import java.io.IOException



class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_finish)

        val finishTime = intent.extras.getString("finishTime")
        val finishTextString = getString(R.string.finishActivityText)
        finishText.text = finishTextString.replace("{finishTime}", finishTime)

        val fileName = "shulteResults.txt"
        if (fileList().contains(fileName)) {
            try {
                val file = InputStreamReader(openFileInput(fileName))
                val br = BufferedReader(file)
                var line: String? = br.readLine()
                val all = StringBuilder()
                while (line != null) {
                    all.append(line + "\n")
                    line = br.readLine()
                }
                br.close()
                file.close()
                finishText.text = all
            }
            catch (e: IOException) {
                finishText.text = e.message
            }
        }

        finishActivityPlayButton.setOnClickListener{
            val gameActivity = Intent(this, GameActivity::class.java)
            startActivity(gameActivity)
        }

        finishActivityMenuButton.setOnClickListener{
            val mainActivity = Intent(this, MainActivity::class.java)
            startActivity(mainActivity)
        }

    }
}
