package com.example.diceroller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val die = Dice(6)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener { rollDice(die) }
        rollDice(die)
    }

    private fun rollDice(die: Dice) {
        val diceImage: ImageView = findViewById(R.id.imageView)

            val value = die.roll()
            Log.d("Rolled a ", value.toString())
            val resource = when(value) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            diceImage.setImageResource(resource)
            diceImage.contentDescription = value.toString()
    }
}