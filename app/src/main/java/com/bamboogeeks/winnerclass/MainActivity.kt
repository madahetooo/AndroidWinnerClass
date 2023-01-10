package com.bamboogeeks.winnerclass

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bamboogeeks.winnerclass.calculatorapp.CalculatorActivity
import com.bamboogeeks.winnerclass.databinding.ActivityMainBinding
import com.bamboogeeks.winnerclass.nav_drawer_app.NavigationDrawerAppActivity
import com.bamboogeeks.winnerclass.restaurant_app.ResturantActivity
import com.bamboogeeks.winnerclass.todolist_app.ui.TodoListActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalculatorApp.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }
        binding.btnRestaurantApp.setOnClickListener {
            val intent = Intent(this, ResturantActivity::class.java)
            startActivity(intent)
        }
        binding.btnTodolistAPP.setOnClickListener {
            val intent = Intent(this, TodoListActivity::class.java)
            startActivity(intent)
        }
        binding.btnNavigationDrawerApp.setOnClickListener {
            val intent = Intent(this, NavigationDrawerAppActivity::class.java)
            startActivity(intent)
        }
    }
}