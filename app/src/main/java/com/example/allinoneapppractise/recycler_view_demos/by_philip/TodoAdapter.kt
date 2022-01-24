package com.example.allinoneapppractise.recycler_view_demos.by_philip

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.allinoneapppractise.R

class TodoAdapter(
    var todos: List<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.tvTitle)
        val checkBox: CheckBox = itemView.findViewById(R.id.cbDone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_todo, parent, false)

        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        /*val textView: TextView = holder.itemView.findViewById(R.id.tvTitle)
        val checkBox: CheckBox = holder.itemView.findViewById(R.id.cbDone)
        textView.text = todos[position].title
        checkBox.isChecked = todos[position].isChecked*/
        holder.textView.text = todos[position].title
        holder.checkBox.isChecked = todos[position].isChecked

    }

    override fun getItemCount(): Int {
        return todos.size
    }
}