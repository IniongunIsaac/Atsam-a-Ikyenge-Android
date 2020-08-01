package com.iniongungroup.mobile.droid.tivhymns.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * Created by Isaac Iniongun on 03/07/2020.
 * For Atsam a Ikyenge project.
 */

@Entity
data class Song(
    val title: String,
    val chorus: String,
    val verses: List<String>,
    @PrimaryKey val id: String = UUID.randomUUID().toString()
    //@ColumnInfo(name = "number_of_verses") val numberOfVerses: Int,
    //val songNumber: Int
)