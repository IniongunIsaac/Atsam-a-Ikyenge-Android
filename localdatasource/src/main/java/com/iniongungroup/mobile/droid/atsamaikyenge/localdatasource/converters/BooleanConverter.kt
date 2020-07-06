package com.iniongungroup.mobile.droid.atsamaikyenge.localdatasource.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by Isaac Iniongun on 06/07/2020.
 * For Atsam a Ikyenge project.
 */

class BooleanConverter{
    companion object {
        @TypeConverter
        @JvmStatic
        fun fromBoolean(value: Boolean?): String? {
            if (value == null) {
                return null
            }
            return Gson().toJson(value)
        }

        @TypeConverter
        @JvmStatic
        fun toBoolean(value: String?): Boolean? {
            if (value == null) {
                return null
            }
            val type = object : TypeToken<Boolean>() {}.type
            return Gson().fromJson(value, type)
        }
    }
}