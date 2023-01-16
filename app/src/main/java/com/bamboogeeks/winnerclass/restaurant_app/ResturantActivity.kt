package com.bamboogeeks.winnerclass.restaurant_app

import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.bamboogeeks.winnerclass.databinding.ActivityResturantBinding

class ResturantActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResturantBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResturantBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnOrder.setOnClickListener {
            val checkedRadioButtonId = binding.rgMeals.checkedRadioButtonId
            val burger = findViewById<RadioButton>(checkedRadioButtonId)
            val cheese = binding.chkCheese.isChecked
            val salad = binding.chkSalad.isChecked
            val onions = binding.chkOnions.isChecked
            val totalOrder = "You Just Ordered a burger with \n " + "${burger.text}" +
                    (if (cheese) "\n Cheese" else "") +
                    (if (salad) "\n Salad" else "") +
                    (if (onions) "\n Onions" else "")
            binding.tvTotalOrder.text = totalOrder
        }
    }
}