package com.bamboogeeks.winnerclass.todolist_app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bamboogeeks.winnerclass.databinding.ActivityTodoListBinding
import com.bamboogeeks.winnerclass.todolist_app.model.Todo
import com.bamboogeeks.winnerclass.todolist_app.utils.TodoAdapter

class TodoListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTodoListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val listOfTodos = mutableListOf(
            Todo("Go To Gym", false),
            Todo("Finish Todo App", false),
            Todo("Finish Shopping Item App", false),
            Todo("Finish Calculator app", false),
            Todo("Finish Restaurant app", false),
            Todo("Go To Sleep", false),
        )
        val ourAdapter = TodoAdapter(listOfTodos)
        binding.rvListOfTodos.adapter = ourAdapter
        binding.rvListOfTodos.layoutManager = LinearLayoutManager(this)

        binding.btnAddTodo.setOnClickListener {
            val newTodoTitle = binding.etTodo.text.toString()
            val newTodo = Todo(newTodoTitle, false)

            listOfTodos.add(newTodo)
            ourAdapter.notifyDataSetChanged()
            binding.etTodo.text.clear()

        }
    }
}