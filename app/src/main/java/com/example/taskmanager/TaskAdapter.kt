package com.example.taskmanager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmanager.databinding.TaskItemCardBinding

class TaskItemAdapter(
    private var taskItems:List<TaskItem>,
    private val clickLisner: TaskitemClickListener
):RecyclerView.Adapter<TaskItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemViewHolder {
       val from = LayoutInflater.from(parent.context)
        val binding = TaskItemCardBinding.inflate(from,parent,false)
        return TaskItemViewHolder(parent.context,binding,clickLisner)
    }

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        holder.bindTaskItem(taskItems[position])
    }

    override fun getItemCount(): Int =taskItems.size
}