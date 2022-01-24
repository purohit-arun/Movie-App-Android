package com.example.allinoneapppractise.recycler_view_demos.by_philip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.allinoneapppractise.R
import com.example.allinoneapppractise.databinding.ActivityMainBinding
import com.example.allinoneapppractise.databinding.ActivityRecyclerViewDemoBinding

class RecyclerViewDemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewDemoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_recycler_view_demo)

        var todoList = mutableListOf(
            Todo("Follow Rules",false),
            Todo("Follow your dreams",false),
            Todo("Follow android",false),
            Todo("Follow Flutter",true),
            Todo("Follow Flutter",true),
            Todo("Follow Flutter",true),
            Todo("Follow Flutter",true),
            Todo("Follow Flutter",true),
        )
        val rvadapter = TodoAdapter(todoList)
        binding.rvTodos.apply {
            adapter = rvadapter
            layoutManager = LinearLayoutManager(this@RecyclerViewDemoActivity)
        }

        binding.btnAddTodo.setOnClickListener{
            val title = binding.etTodo.text.toString()
            val todo = Todo(title,false)
            todoList.add(todo)
            rvadapter.notifyItemInserted(todoList.size - 1)
        }
    }
}