package com.example.taskmanager

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID

class TaskViewModel(private val repository: TaskitemRepository) :ViewModel (){
    var taskItems :LiveData<List<TaskItem>> = repository.allTaskItems.asLiveData()


    fun addTaskItem(newTask :TaskItem) = viewModelScope.launch {
        repository.insertTaskItem(newTask)
    }
    fun updateTaskItem(taskItem :TaskItem)= viewModelScope.launch {
        repository.updateTaskItem(taskItem)
    }
    fun setCompleted(taskItem :TaskItem)= viewModelScope.launch {
        if(!taskItem.iscompleted())
            taskItem.completeDateString =TaskItem.dateFormatter.format(LocalDate.now())
        repository.updateTaskItem(taskItem)
    }
    fun deleteTaskItem(taskItem: TaskItem) = viewModelScope.launch {
        repository.deleteTaskItem(taskItem)
    }

    fun deleteTaskItemById(taskId: Int) = viewModelScope.launch {
        repository.deleteTaskItemById(taskId)
    }


}

class TaskItemModelFactory(private val repository: TaskitemRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TaskViewModel::class.java))
            return TaskViewModel(repository)as T

        throw IllegalArgumentException("Unkonwn Class")
    }
}