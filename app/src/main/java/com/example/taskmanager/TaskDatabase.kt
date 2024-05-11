package com.example.taskmanager

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [TaskItem::class], version = 1, exportSchema = false)
abstract class TaskitemDatabase: RoomDatabase() {

    abstract fun taskitemDa0():TaskitemDao


    companion object{
        @Volatile
        private var INSTANCE:TaskitemDatabase? = null

        fun getDatabase(context: Context):TaskitemDatabase{
        return INSTANCE ?: synchronized(this){
            val instance = Room.databaseBuilder(context.applicationContext,TaskitemDatabase::class.java,"task_item_database").build()
            INSTANCE = instance
            instance
        }
        }
    }
}