package com.soyinka.soyombo.quizapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.question.*

/**
 * Created by Soyombo Soyinka on 5/20/2018.
 */

class QuizActivity : AppCompatActivity() {

    internal var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.question)

        //Intent sent from MainActivity.kt is captured here, this is the username, for display.
        welcome.text = intent.getStringExtra("EdiTtEXTvALUE")
    }

    fun submitAnswer(view: View) {
        //This assesses the correct answer to question 1.
        val answerToQuestion1 = none.isChecked
        if (answerToQuestion1) {
            score += 1
        }
        //This assesses the correct answer to question 2.
        val answerToQuestion2 = undefined.isChecked
        if (answerToQuestion2) {
            score += 1
        }
        //This assesses the correct answer to question 3.
        val answerToQuestion3 = entityB.isChecked
        if (answerToQuestion3) {
            score += 1
        }
        //This assesses the correct answer to question 4.
        val answerToQuestion4 = entityA1.isChecked
        if (answerToQuestion4) {
            score += 1
        }
        //This assesses the correct answer to question 5.
        val answerToQuestion5a = abc.isChecked
        val answerToQuestion5b = def.isChecked
        val answerToQuestion5c = bcd.isChecked
        val answerToQuestion5d = cde.isChecked

        score += when {
            (answerToQuestion5a && answerToQuestion5b) && !answerToQuestion5d && !answerToQuestion5c -> 1
            else -> 0
        }

        //This assesses the correct answer to question 6.
        val answerToQuestion6 = edit.text.toString()
        score += when (answerToQuestion6) {
            "Particle A" -> 1
            else -> 0
        }
        
        //Toast messages to display on submission and the navigation intent to restart the quiz
        Toast.makeText(this, "Thanks for taking this quiz", Toast.LENGTH_SHORT).show()
        //sleep(500)
        Toast.makeText(this, "You scored $score out of 6", Toast.LENGTH_LONG).show()
        score = 0
        
        //Restart quiz by going back to the home page
        startActivity(Intent(this@QuizActivity, MainActivity::class.java))
        finish()
    }
}
