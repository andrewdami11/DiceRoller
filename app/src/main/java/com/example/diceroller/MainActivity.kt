package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var dice_1_image: ImageView
    private lateinit var dice_2_image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dice_1_image = findViewById(R.id.dice_1_image)
        dice_2_image = findViewById(R.id.dice_2_image)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }
        val clearButton: Button = findViewById(R.id.clear_button)
        clearButton.setOnClickListener { clearButton() }
    }

    private fun clearButton() {
        dice_1_image.setImageResource(R.drawable.empty_dice)
        dice_2_image.setImageResource(R.drawable.empty_dice)
    }

    private fun rollDice() {
        dice_1_image.setImageResource(getDrawableResource())
        dice_2_image.setImageResource(getDrawableResource())
    }

    private fun getDrawableResource(): Int {
        val n: Int = Random.nextInt(6) + 1
        return when (n) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}
