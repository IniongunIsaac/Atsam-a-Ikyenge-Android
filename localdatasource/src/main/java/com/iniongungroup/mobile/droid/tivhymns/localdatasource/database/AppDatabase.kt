package com.iniongungroup.mobile.droid.tivhymns.localdatasource.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.iniongungroup.mobile.droid.tivhymns.entities.*
import com.iniongungroup.mobile.droid.tivhymns.localdatasource.converters.BooleanConverter
import com.iniongungroup.mobile.droid.tivhymns.localdatasource.converters.DateTimeTypeConverter
import com.iniongungroup.mobile.droid.tivhymns.localdatasource.converters.StringListConverter
import com.iniongungroup.mobile.droid.tivhymns.localdatasource.dao.*
import com.iniongungroup.mobile.droid.tivhymns.localdatasource.utils.LocalDataSourceConstants

/**
 * Created by Isaac Iniongun on 06/07/2020.
 * For Atsam a Ikyenge project.
 */

@Database(
    entities = [
        Song::class,
        FontStyle::class,
        Setting::class,
        Favorite::class,
        Theme::class
    ],
    version = LocalDataSourceConstants.DB_VERSION
)

@TypeConverters(BooleanConverter::class, DateTimeTypeConverter::class, StringListConverter::class)

abstract class AppDatabase : RoomDatabase() {

    abstract fun fontStylesDao(): FontStyleDao

    abstract fun settingsDao(): SettingsDao

    abstract fun themesDao(): ThemeDao

    abstract fun songsDao(): SongsDao

    abstract fun favoritesDao(): FavoriteDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            AppDatabase::class.java, LocalDataSourceConstants.DB_NAME
        ).build()
    }

}