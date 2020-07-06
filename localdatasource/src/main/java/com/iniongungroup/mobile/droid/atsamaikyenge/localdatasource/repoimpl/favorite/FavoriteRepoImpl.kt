package com.iniongungroup.mobile.droid.atsamaikyenge.localdatasource.repoimpl.favorite

import com.iniongungroup.mobile.droid.atsamaikyenge.entities.Favorite
import com.iniongungroup.mobile.droid.atsamaikyenge.localdatasource.dao.FavoriteDao
import com.iniongungroup.mobile.droid.atsamaikyenge.repository.localdatasource.favorites.IFavoritesRepo
import javax.inject.Inject

/**
 * Created by Isaac Iniongun on 06/07/2020.
 * For Atsam a Ikyenge project.
 */

class FavoriteRepoImpl @Inject constructor(
    private val favoriteDao: FavoriteDao
): IFavoritesRepo {

    override fun getAllFavorites() = favoriteDao.getAllFavorites()

    override fun getFavoriteById(favoriteId: String) = favoriteDao.getFavoriteById(favoriteId)

    override fun insertFavorites(favorites: List<Favorite>) = favoriteDao.insertFavorites(favorites)

    override fun deleteFavorites(favorites: List<Favorite>) = favoriteDao.deleteFavorites(favorites)

    override fun deleteFavorites() = favoriteDao.deleteFavorites()
}