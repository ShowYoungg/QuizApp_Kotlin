package com.soyinka.soyombo.quizapp

import android.app.Activity
import android.content.Intent
import android.content.IntentSender
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         * this sets onClickListener on the button element; this is another way of setting onClick listener in java...
         * on a button instead of declaring it in xml file
         */
        take_quiz.setOnClickListener {
            val quizIntent = Intent(this, QuizActivity::class.java)
            quizIntent.putExtra("EdiTtEXTvALUE", "Welcome " + name_field.text)
            startActivity(quizIntent)
            finish()
        }

    }
}
