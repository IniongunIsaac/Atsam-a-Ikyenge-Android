package com.iniongungroup.mobile.droid.atsamaikyenge.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import org.threeten.bp.OffsetDateTime
import java.util.*

/**
 * Created by Isaac Iniongun on 03/07/2020.
 * For Atsam a Ikyenge project.
 */

@Entity(
    foreignKeys = [
        ForeignKey(entity = Song::class, parentColumns = ["id"], childColumns = ["song_id"])
    ]
)
data class Favorite(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "favorite_date") val favoriteDate: OffsetDateTime,
    @ColumnInfo(name = "song_id") val songId: String
)