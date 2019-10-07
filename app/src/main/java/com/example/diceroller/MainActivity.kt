package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener{rollDice()}
        val countUpButton: Button = findViewById(R.id.count_up_button)
        countUpButton.setOnClickListener{countUp()}
    }

    private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)
        var number = resultText.text.toString().toIntOrNull()
        resultText.text = number.toString()
        when (number) {
            null -> resultText.text = "1"
            in 1..5 -> {number++; resultText.text = number.toString()}
        }
    }

    private fun rollDice(){
        val resultText: TextView = findViewById(R.id.result_text)
        val randomInt: Int = Random.nextInt(6) + 1
        resultText.text = randomInt.toString()
    }
}
