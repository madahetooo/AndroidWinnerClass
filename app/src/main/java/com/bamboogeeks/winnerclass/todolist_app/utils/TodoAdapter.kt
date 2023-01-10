package com.bamboogeeks.winnerclass.todolist_app.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bamboogeeks.winnerclass.databinding.ItemTodoBinding
import com.bamboogeeks.winnerclass.todolist_app.model.Todo

class TodoAdapter(var todos: List<Todo>) :
RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){
    inner class TodoViewHolder(val binding: ItemTodoBinding):
            RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(ItemTodoBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.binding.apply {
            txItemTodo.text = todos[position].todoTitle
            chkTodoDone.isChecked = todos[position].isChecked
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}