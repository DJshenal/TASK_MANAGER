package com.example.taskmanager

import android.app.Application

class Task_Manager_Application: Application() {
    private val database by lazy {TaskitemDatabase.getDatabase(this)}
    val repository by lazy {TaskitemRepository(database.taskitemDa0())}
}