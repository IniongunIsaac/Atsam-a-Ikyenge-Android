package com.iniongungroup.mobile.droid.tivhymnsi.repository.localdatasource.fontstyle

import com.iniongungroup.mobile.droid.tivhymnsi.entities.FontStyle
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Isaac Iniongun on 06/07/2020.
 * For Atsam a Ikyenge project.
 */

interface IFontStyleRepo {

    fun getAllFontStyles(): Observable<List<FontStyle>>

    fun getFontStyleByName(fontStyleName: String): Single<FontStyle>

    fun getFontStyleById(fontStyleId: String): Single<FontStyle>

    fun insertFontStyles(fontStyles: List<FontStyle>): Completable

    fun deleteFontStyles(fontStyles: List<FontStyle>): Completable

    fun deleteAllFontStyles(): Completable

}