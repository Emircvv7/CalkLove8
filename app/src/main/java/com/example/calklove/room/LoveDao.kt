package com.example.calklove.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.calklove.remote.LoveModel

@Dao
interface LoveDao {

    @Insert
    fun insertLove(love: LoveModel)

    @Query("SELECT * FROM `love-table` ORDER BY firstName ASC, secondName ASC, percentage ASC, result ASC")
    fun getAllSorted(): List<LoveModel>


    @Delete
    fun delete(love: LoveModel)
}
