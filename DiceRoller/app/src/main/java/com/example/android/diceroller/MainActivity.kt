package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import java.util.Random

class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView
    var currentDice: Int? = null
    val drawableDiceResource: Int
        get() = when (currentDice ?: 1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.dice_image)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            rollDice()
        }

        val countUpButton: Button = findViewById(R.id.count_up_button)
        countUpButton.setOnClickListener {
            countUp()
        }

    }

    private fun rollDice() {
        val randomInt = Random().nextInt(6) + 1
        currentDice = randomInt
        diceImage.setImageResource(drawableDiceResource)
    }

    private fun countUp() {
        var incrementedNumber: Int
        val currentDice = currentDice
        if (currentDice != null) {
            incrementedNumber = currentDice + 1
            if (incrementedNumber >= 7) {
                incrementedNumber = 1
            }
        } else {
            incrementedNumber = 1
        }
        this.currentDice = incrementedNumber

        diceImage.setImageResource(drawableDiceResource)
    }
}
