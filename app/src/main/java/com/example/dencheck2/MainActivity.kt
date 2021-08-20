package com.example.dencheck2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.dencheck2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainQuote: MainQuote = MainQuote("there are two kinds of people", "lex luthor")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainQuote = mainQuote


        val rollButton: Button = binding.rollButton
        rollButton.setOnClickListener{rollDice()}

        val countButton: Button = binding.saveButton
        countButton.setOnClickListener{clickOnSaveButton(it)}
    }

    private fun rollDice () {
        val randomInt = (1..6).random()
        val randomInt2 = (1..6).random()

        val diceDrawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val diceDrawableResource2 = when (randomInt2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        var totalInt = randomInt + randomInt2

        binding.resultText.text = totalInt.toString()
        binding.diceImage.setImageResource(diceDrawableResource)
        binding.diceImage2.setImageResource(diceDrawableResource2)
    }


    private fun clickOnSaveButton (view: View) {
        binding.mainHeader.text = binding.editUserName.text
        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}