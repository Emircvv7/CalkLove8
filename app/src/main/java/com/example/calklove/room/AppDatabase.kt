package com.example.calklove.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.calklove.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun loveDao(): LoveDao
}