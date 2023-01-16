package com.bamboogeeks.winnerclass.shopping_item_app.repository

import com.bamboogeeks.winnerclass.shopping_item_app.db.ShoppingDatabase
import com.bamboogeeks.winnerclass.shopping_item_app.model.ShoppingItem

class ShoppingRepository(private val db:ShoppingDatabase) {

    fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun readAll() = db.getShoppingDao().readAll()
}