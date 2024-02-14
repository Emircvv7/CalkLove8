package com.example.calklove.remote

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable


@Entity(tableName = "love-table")
data class LoveModel(
    @SerializedName("fname")
    var firstName: String,
    @SerializedName("sname")
    var secondName: String,
    var percentage: String,
    var result: String,

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
):Serializable