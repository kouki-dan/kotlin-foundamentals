package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


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
        // Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
        val resultText: TextView = findViewById(R.id.result_text)
        val randomInt = Random().nextInt(6) + 1
        resultText.text = randomInt.toString()
    }

    private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)

        var incrementedNumber: Int
        try {
            incrementedNumber = Integer.parseInt(resultText.text.toString()) + 1
            if (incrementedNumber >= 7) {
                incrementedNumber = 1
            }
        } catch (_: NumberFormatException) {
            incrementedNumber = 1
        }

        resultText.text = incrementedNumber.toString()
    }
}
