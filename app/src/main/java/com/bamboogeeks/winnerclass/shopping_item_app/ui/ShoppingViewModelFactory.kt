package com.bamboogeeks.winnerclass.shopping_item_app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bamboogeeks.winnerclass.shopping_item_app.repository.ShoppingRepository

class ShoppingViewModelFactory(private val repository: ShoppingRepository) :
ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }
}