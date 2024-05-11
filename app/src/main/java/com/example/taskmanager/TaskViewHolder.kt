package com.example.taskmanager

import android.content.Context
import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmanager.databinding.TaskItemCardBinding
import java.time.format.DateTimeFormatter

class TaskItemViewHolder(
    private var context: Context,
    private var binding:TaskItemCardBinding,
    private val clickLisner: TaskitemClickListener
):RecyclerView.ViewHolder(binding.root) {
    private val timeFormat = DateTimeFormatter.ofPattern("HH:mm")

    fun bindTaskItem(taskItem:TaskItem){
        binding.name.text = taskItem.name

        if(taskItem.iscompleted()) {
            binding.name.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            binding.dueTime.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        }
        binding.completebutton.setImageResource(taskItem.imagResourse())
        binding.completebutton.setColorFilter(taskItem.imageColor(context))

        binding.completebutton.setOnClickListener{
            clickLisner.completeTaskItem(taskItem)
        }

        binding.taskcontainer.setOnClickListener{
            clickLisner.editTaskItem(taskItem)
        }
        if(taskItem.dueTime()!= null)
            binding.dueTime.text = timeFormat.format(taskItem.dueTime())
        else
            binding.dueTime.text = ""

        binding.deleteButton.setOnClickListener {
            clickLisner.deleteTaskItem(taskItem)
        }
    }

}