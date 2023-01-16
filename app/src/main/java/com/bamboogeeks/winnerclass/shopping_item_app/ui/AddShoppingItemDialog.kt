package com.bamboogeeks.winnerclass.shopping_item_app.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.bamboogeeks.winnerclass.databinding.DialogAddShoppingItemBinding
import com.bamboogeeks.winnerclass.shopping_item_app.model.ShoppingItem

class AddShoppingItemDialog(context: Context,var adDialogListener : AddDialogListener)
    : AppCompatDialog(context){

    private lateinit var binding:DialogAddShoppingItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogAddShoppingItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnShoppingDialogAdd.setOnClickListener {
           var shoppingItemName = binding.etShoppingItemDialogName.text.toString()
           var shoppingItemAmount = binding.etShoppingItemDialogAmount.text.toString()

            if (shoppingItemName.isEmpty() || shoppingItemAmount.isEmpty()){
                Toast.makeText(context,"Please enter item name and amount",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
           var item = ShoppingItem(shoppingItemName,shoppingItemAmount.toInt())
            adDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        binding.btnShoppingDialogCancel.setOnClickListener {
            cancel()
        }
    }
}