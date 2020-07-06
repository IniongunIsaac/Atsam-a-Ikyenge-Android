package com.iniongungroup.mobile.droid.atsamaikyenge.localdatasource.dao

import androidx.room.*
import com.iniongungroup.mobile.droid.atsamaikyenge.entities.Favorite
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Isaac Iniongun on 06/07/2020.
 * For Atsam a Ikyenge project.
 */

@Dao
interface FavoriteDao {

    @Query("select * from Favorite")
    fun getAllFavorites(): Observable<List<Favorite>>

    @Query("select * from Favorite where id = :favoriteId")
    fun getFavoriteById(favoriteId: String): Single<Favorite>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavorites(vararg favorites: Favorite): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavorites(favorites: List<Favorite>): Completable

    @Delete
    fun deleteFavorites(favorites: List<Favorite>): Completable

    @Query("delete from Favorite")
    fun deleteFavorites(): Completable
    
}