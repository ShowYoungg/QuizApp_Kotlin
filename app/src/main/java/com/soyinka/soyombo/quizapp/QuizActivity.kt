package com.soyinka.soyombo.quizapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.question.*

/**
 * Created by SHOW on 5/20/2018.
 */

class QuizActivity : AppCompatActivity() {

    //private lateinit var binding2: ActivityMainBinding

    //@global: variable to keep track of the number of correct answers
    internal var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.question)
        //binding2 = DataBindingUtil.setContentView(this, R.layout.question)

        /**
         * Username from MainActivity is thrown down here, so that it can be displayed in this activity class.
         * @param: username from MainActivity
         */
        //val setUserName = findViewById<TextView>(R.id.welcome)
        welcome.text = intent.getStringExtra("EdiTtEXTvALUE")
    }

    fun submitAnswer(view: View) {
        //This assesses the correct answer to question 1.
        //val questionOneAnswer = findViewById<RadioButton>(R.id.none)
        //none
        val answerToQuestion1 = none.isChecked
        if (answerToQuestion1) {
            score += 1
        }
        //This assesses the correct answer to question 2.
        //val questionTwoAnswer = findViewById<RadioButton>(R.id.undefined)
        val answerToQuestion2 = undefined.isChecked
        if (answerToQuestion2) {
            score += 1
        }
        //This assesses the correct answer to question 3.
        //val questionThreeAnswer = findViewById<RadioButton>(R.id.entityB)
        val answerToQuestion3 = entityB.isChecked
        if (answerToQuestion3) {
            score += 1
        }
        //This assesses the correct answer to question 4.
        //val questionFourAnswer = findViewById<RadioButton>(R.id.entityA1)
        val answerToQuestion4 = entityA1.isChecked
        if (answerToQuestion4) {
            score += 1
        }
        //This assesses the correct answer to question 5.
        //val questionFiveAnswerA = findViewById<CheckBox>(R.id.abc)
        val answerToQuestion5a = abc.isChecked

        //val questionFiveAnswerB = findViewById<CheckBox>(R.id.def)
        val answerToQuestion5b = def.isChecked

        //val questionFiveAnswerC = findViewById<CheckBox>(R.id.bcd)
        val answerToQuestion5c = bcd.isChecked

        //val questionFiveAnswerD = findViewById<CheckBox>(R.id.cde)
        val answerToQuestion5d = cde.isChecked


        score += when {
            (answerToQuestion5a && answerToQuestion5b) && !answerToQuestion5d && !answerToQuestion5c -> 1
            else -> 0
        }

        //This assesses the correct answer to question 6.
        //val questionSixAnswer = findViewById<EditText>(R.id.edit)
        val answerToQuestion6 = edit.text.toString()
        score += when (answerToQuestion6) {
            "Particle A" -> 1
            else -> 0
        }
//        if (answerToQuestion6 === "Particle A") {
//            score += 1
//        }
        /**
         * toast messages to display on submission and the navigation intent to restart the quiz
         */

        Toast.makeText(this, "Thanks for taking this quiz", Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "You scored $score out of 6", Toast.LENGTH_LONG).show()
        score = 0
        //Restart quiz by going back to the home page
        startActivity(Intent(this@QuizActivity, MainActivity::class.java))
        finish()
    }

}
