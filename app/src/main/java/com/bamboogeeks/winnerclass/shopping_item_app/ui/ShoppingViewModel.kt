package com.bamboogeeks.winnerclass.shopping_item_app.ui

import androidx.lifecycle.ViewModel
import com.bamboogeeks.winnerclass.shopping_item_app.model.ShoppingItem
import com.bamboogeeks.winnerclass.shopping_item_app.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel (private val repository: ShoppingRepository) : ViewModel(){

    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.IO).launch {
        repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.IO).launch {
        repository.delete(item)
    }

    fun readAll() = repository.readAll()
}