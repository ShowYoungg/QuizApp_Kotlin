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
//import com.soyinka.soyombo.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main )

        //input to EditText is caught so as to be passed to the other activity class
        //val nameField = findViewById<EditText>(R.id.name_field)
        //binding.nameField.text
        name_field.text
        //val takeQuiz = findViewById<Button>(R.id.take_quiz)

        /**
         * this sets onClickListener on the button element; this is another way of setting onClick listener in java...
         * on a button instead of declaring it in xml file
         */
        take_quiz.setOnClickListener {
            //two intents are passed at a time i.e to get to the next activity and to throw the user name from EditText with putExtra()
            //val quizIntent = Intent(this@MainActivity, QuizActivity::class.java)
            val quizIntent = Intent(this, QuizActivity::class.java)
            quizIntent.putExtra("EdiTtEXTvALUE", "Welcome " + name_field.text)
            startActivity(quizIntent)
            finish()
        }

    }
}
