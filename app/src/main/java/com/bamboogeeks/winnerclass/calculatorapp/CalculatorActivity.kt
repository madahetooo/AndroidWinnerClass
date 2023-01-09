package com.bamboogeeks.winnerclass.calculatorapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bamboogeeks.winnerclass.databinding.ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalculatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAdd.setOnClickListener {
            if (binding.etFirstNumber.text.isNotEmpty() && binding.etSecondNumber.text.isNotEmpty()) {
                val firstNumber = binding.etFirstNumber.text.toString().toInt()
                val secondNumber = binding.etSecondNumber.text.toString().toInt()
                val result = firstNumber + secondNumber
                binding.txResult.text = result.toString()
            } else {
                Toast.makeText(this, "Not Valid Input", Toast.LENGTH_LONG).show()
            }
        }
        binding.btnSub.setOnClickListener {
            if (binding.etFirstNumber.text.isNotEmpty() && binding.etSecondNumber.text.isNotEmpty()) {
                val firstNumber = binding.etFirstNumber.text.toString().toInt()
                val secondNumber = binding.etSecondNumber.text.toString().toInt()
                val result = firstNumber - secondNumber
                binding.txResult.text = result.toString()
            } else {
                Toast.makeText(this, "Not Valid Input", Toast.LENGTH_LONG).show()
            }
        }
        binding.btnMultiply.setOnClickListener {
            if (binding.etFirstNumber.text.isNotEmpty() && binding.etSecondNumber.text.isNotEmpty()) {
                val firstNumber = binding.etFirstNumber.text.toString().toInt()
                val secondNumber = binding.etSecondNumber.text.toString().toInt()
                val result = firstNumber * secondNumber
                binding.txResult.text = result.toString()
            } else {
                Toast.makeText(this, "Not Valid Input", Toast.LENGTH_LONG).show()
            }
        }
        binding.btnDivide.setOnClickListener {
            if (binding.etFirstNumber.text.isNotEmpty()
                && binding.etSecondNumber.text.isNotEmpty()
            ) {
                val firstNumber = binding.etFirstNumber.text.toString().toInt()
                val secondNumber = binding.etSecondNumber.text.toString().toInt()
                if (secondNumber == 0) {
                    Toast.makeText(this, "Not Valid Input", Toast.LENGTH_LONG).show()

                } else {
                    val result = firstNumber / secondNumber
                    binding.txResult.text = result.toString()
                }

            } else {
                Toast.makeText(this, "Not Valid Input", Toast.LENGTH_LONG).show()
            }
        }
        binding.btnResetValues.setOnClickListener {
            binding.etFirstNumber.text.clear()
            binding.etSecondNumber.text.clear()
            binding.txResult.setText("")
            Toast.makeText(this, "Value Reseted", Toast.LENGTH_LONG).show()
        }
    }
}