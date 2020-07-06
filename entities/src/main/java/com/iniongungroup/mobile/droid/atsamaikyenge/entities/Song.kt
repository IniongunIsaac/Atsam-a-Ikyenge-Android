package com.iniongungroup.mobile.droid.atsamaikyenge.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * Created by Isaac Iniongun on 03/07/2020.
 * For Atsam a Ikyenge project.
 */

@Entity
data class Song(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val title: String,
    val chorus: String,
    val verses: List<String>,
    @ColumnInfo(name = "number_of_verses") val numberOfVerses: Int,
    val songNumber: Int
)