package com.iniongungroup.mobile.droid.atsamaikyenge.repository.localdatasource.theme

import com.iniongungroup.mobile.droid.atsamaikyenge.entities.Theme
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Isaac Iniongun on 06/07/2020.
 * For Atsam a Ikyenge project.
 */

interface IThemeRepo {

    fun getAllThemes(): Observable<List<Theme>>

    fun getThemeById(themeId: String): Single<Theme>

    fun insertThemes(themes: List<Theme>): Completable

    fun deleteThemes(themes: List<Theme>): Completable

    fun deleteThemes(): Completable

    fun getThemeByName(name: String): Single<Theme>

}