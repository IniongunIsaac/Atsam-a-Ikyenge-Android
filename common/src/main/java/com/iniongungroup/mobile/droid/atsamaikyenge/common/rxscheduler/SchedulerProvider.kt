package com.iniongungroup.mobile.droid.atsamaikyenge.common.rxscheduler

import io.reactivex.Scheduler

/**
 * Created by Isaac Iniongun on 03/07/2020.
 * For Atsam a Ikyenge project.
 */

interface SchedulerProvider {

    fun ui(): Scheduler

    fun computation(): Scheduler

    fun io(): Scheduler

}