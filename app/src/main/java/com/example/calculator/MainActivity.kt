package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var workingsTV: TextView
    private lateinit var resultsTV: TextView

    private var workings: String = ""
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operator: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        workingsTV = findViewById(R.id.workingsTV)
        resultsTV = findViewById(R.id.resultsTV)
    }

    fun onNumberClick(view: View) {
        val button = view as Button
        workings += button.text
        workingsTV.text = workings
    }

    fun onOperatorClick(view: View) {
        val button = view as Button
        operator = button.text.toString()
        num1 = workings.toDouble()
        workings = ""
        workingsTV.text = workings
    }

    fun onEqualsClick(view: View) {
        num2 = workings.toDouble()
        var result = 0.0
        when (operator) {
            "+" -> result = num1 + num2
            "-" -> result = num1 - num2
            "x" -> result = num1 * num2
            "/" -> result = num1 / num2
        }
        resultsTV.text = result.toString()
        workings = ""
        workingsTV.text = workings
    }

}
