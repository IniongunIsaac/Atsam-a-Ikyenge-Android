package com.iniongungroup.mobile.droid.atsamaikyenge.localdatasource.dao

import androidx.room.*
import com.iniongungroup.mobile.droid.atsamaikyenge.entities.Theme
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Isaac Iniongun on 06/07/2020.
 * For Atsam a Ikyenge project.
 */

@Dao
interface ThemeDao {

    @Query("select * from Theme")
    fun getAllThemes(): Observable<List<Theme>>

    @Query("select * from Theme where id = :themeId limit 1")
    fun getThemeById(themeId: String): Single<Theme>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertThemes(vararg themes: Theme): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertThemes(themes: List<Theme>): Completable

    @Delete
    fun deleteThemes(themes: List<Theme>): Completable

    @Query("delete from Theme")
    fun deleteThemes(): Completable

    @Query("select * from Theme where name like '%' || :name || '%' limit 1")
    fun getThemeByName(name: String): Single<Theme>

}