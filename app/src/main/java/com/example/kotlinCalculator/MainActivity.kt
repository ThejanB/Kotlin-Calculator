package com.example.kotlinCalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.MultiAutoCompleteTextView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.log

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var add_button: Button
    lateinit var subtract_button: Button
    lateinit var multiply_button: Button
    lateinit var divide_button: Button
    lateinit var clear_button: Button
    lateinit var answer: TextView
    lateinit var number_1: EditText
    lateinit var number_2: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        number_1 = findViewById(R.id.number_1)
        number_2 = findViewById(R.id.number_2)
        add_button = findViewById(R.id.add_button)
        subtract_button = findViewById(R.id.subtract_button)
        multiply_button = findViewById(R.id.multiply_button)
        divide_button = findViewById(R.id.divide_button)
        clear_button = findViewById(R.id.clear_button)
        answer = findViewById(R.id.answer)

        add_button.setOnClickListener(this)
        subtract_button.setOnClickListener(this)
        multiply_button.setOnClickListener(this)
        divide_button.setOnClickListener(this)
        clear_button.setOnClickListener(this)

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        try {
            var number1 : Double = number_1.text.toString().toDouble()
            var number2 : Double  = number_2.text.toString().toDouble()
            var result = 0.0

            when (v?.id) {
                R.id.add_button -> {
                    result = (number1 + number2)
                }

                R.id.subtract_button -> {
                    result = (number1 - number2)
                }

                R.id.multiply_button -> {
                    result = (number1 * number2)
                }

                R.id.divide_button -> {
                    if (number2 == 0.0) {
                        answer.text = "Cannot divide by zero"
                        return
                    } else {
                        result = number1 / number2
                    }
                }

                R.id.clear_button -> {
                    number_1.text.clear()
                    number_2.text.clear()
                    answer.text = ""
                    return
                }
            }
            answer.text = "Answer: $result"
        } catch (e: NumberFormatException) {
            answer.text = "Invalid input"
        }
    }
}