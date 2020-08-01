package com.iniongungroup.mobile.droid.tivhymns.common.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iniongungroup.mobile.droid.tivhymns.common.livedataevent.LiveDataEvent
import com.iniongungroup.mobile.droid.tivhymns.common.state.AppResult
import com.iniongungroup.mobile.droid.tivhymns.common.state.AppState
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Isaac Iniongun on 03/07/2020.
 * For Atsam a Ikyenge project.
 */

abstract class BaseViewModel: ViewModel() {

    val _notificationLiveData = MutableLiveData<LiveDataEvent<AppResult<Unit>>>()
    val notificationLiveData = _notificationLiveData as LiveData<LiveDataEvent<AppResult<Unit>>>

    val compositeDisposable = CompositeDisposable()

    fun postLoadingState() {
        _notificationLiveData.value = LiveDataEvent(AppResult.loading())
    }

    fun removeLoadingState() {
        _notificationLiveData.value = LiveDataEvent(AppResult.success())
    }

    fun postSuccessMessage(message: String? = null) {
        _notificationLiveData.value = LiveDataEvent(AppResult.success(message = message))
    }

    fun postFailureNotification(message: String? = null) {
        _notificationLiveData.value = LiveDataEvent(AppResult.failed(message))
    }

    fun setMessage(message: String, messageType: AppState) {
        when(messageType) {
            AppState.FAILED -> _notificationLiveData.value = LiveDataEvent(AppResult.failed(message))
            AppState.SUCCESS -> _notificationLiveData.value = LiveDataEvent(AppResult.success(message = message))
        }

    }

    override fun onCleared() {
        super.onCleared()

        compositeDisposable.clear()
    }

}