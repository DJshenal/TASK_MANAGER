package com.example.taskmanager

import androidx.annotation.WorkerThread
import androidx.room.Dao
import kotlinx.coroutines.flow.Flow

class TaskitemRepository(private val taskItemDao: TaskitemDao) {

    val allTaskItems: Flow<List<TaskItem>> = taskItemDao.allTaskItems()

    @WorkerThread
    suspend fun insertTaskItem(taskItem: TaskItem){
        taskItemDao.insertTaskItem(taskItem)
    }

    @WorkerThread
    suspend fun updateTaskItem(taskItem: TaskItem){
        taskItemDao.updateTaskItem(taskItem)
    }
    @WorkerThread
    suspend fun deleteTaskItem(taskItem: TaskItem) {
        taskItemDao.deleteTaskItem(taskItem)
    }

    @WorkerThread
    suspend fun deleteTaskItemById(taskId: Int) {
        taskItemDao.deleteTaskItemById(taskId)
    }
}