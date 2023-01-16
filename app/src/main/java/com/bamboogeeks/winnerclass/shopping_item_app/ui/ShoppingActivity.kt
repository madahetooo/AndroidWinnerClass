package com.bamboogeeks.winnerclass.shopping_item_app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bamboogeeks.winnerclass.databinding.ActivityShoppingBinding
import com.bamboogeeks.winnerclass.shopping_item_app.db.ShoppingDatabase
import com.bamboogeeks.winnerclass.shopping_item_app.model.ShoppingItem
import com.bamboogeeks.winnerclass.shopping_item_app.repository.ShoppingRepository
import com.bamboogeeks.winnerclass.shopping_item_app.ui.utils.ShoppingItemAdapter

class ShoppingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory).get(ShoppingViewModel::class.java)

        val shoppingItemAdapter = ShoppingItemAdapter(listOf(), viewModel)
        binding.rvShoppingItems.layoutManager = LinearLayoutManager(this)
        binding.rvShoppingItems.adapter = shoppingItemAdapter

        viewModel.readAll().observe(this, Observer { listOfShoppingItems ->
            shoppingItemAdapter.items = listOfShoppingItems
            shoppingItemAdapter.notifyDataSetChanged()
        })

        binding.fabAddShoppingItem.setOnClickListener {
            AddShoppingItemDialog(this, object : AddDialogListener {
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }
    }
}