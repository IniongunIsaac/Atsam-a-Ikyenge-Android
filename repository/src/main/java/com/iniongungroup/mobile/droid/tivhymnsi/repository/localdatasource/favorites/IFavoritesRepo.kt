package com.iniongungroup.mobile.droid.tivhymnsi.repository.localdatasource.favorites

import com.iniongungroup.mobile.droid.tivhymnsi.entities.Favorite
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Isaac Iniongun on 06/07/2020.
 * For Atsam a Ikyenge project.
 */

interface IFavoritesRepo {

    fun getAllFavorites(): Observable<List<Favorite>>

    fun getFavoriteById(favoriteId: String): Single<Favorite>

    fun insertFavorites(favorites: List<Favorite>): Completable

    fun deleteFavorites(favorites: List<Favorite>): Completable

    fun deleteFavorites(): Completable

}