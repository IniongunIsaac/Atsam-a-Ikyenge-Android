package com.iniongungroup.mobile.droid.tivhymns.localdatasource.dao

import androidx.room.*
import com.iniongungroup.mobile.droid.tivhymns.entities.Setting
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Isaac Iniongun on 06/07/2020.
 * For Atsam a Ikyenge project.
 */

@Dao
interface SettingsDao {

    @Query("select * from Setting")
    fun getAllSettings(): Observable<List<Setting>>

    @Query("select * from Setting where id = :settingId limit 1")
    fun getSettingById(settingId: String): Single<Setting>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSettings(vararg settings: Setting): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSettings(settings: List<Setting>): Completable

    @Delete
    fun deleteSettings(settings: List<Setting>): Completable

    @Query("delete from Setting")
    fun deleteSettings(): Completable

    @Update
    fun updateSettings(setting: Setting): Completable

}