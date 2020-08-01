package com.iniongungroup.mobile.droid.tivhymns.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * Created by Isaac Iniongun on 03/07/2020.
 * For Atsam a Ikyenge project.
 */

@Entity
data class Setting(
    @ColumnInfo(name = "font_size") var fontSize: Int,
    @ColumnInfo(name = "line_spacing")var lineSpacing: Int,
    @Embedded(prefix = "font_style_") var fontStyle: FontStyle,
    @Embedded(prefix = "theme_") var theme: Theme,
    @ColumnInfo(name = "stay_awake") var stayAwake: Boolean,
    @PrimaryKey val id: String = UUID.randomUUID().toString()
)