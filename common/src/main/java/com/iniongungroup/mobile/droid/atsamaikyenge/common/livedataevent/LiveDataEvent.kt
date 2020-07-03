package com.iniongungroup.mobile.droid.atsamaikyenge.common.livedataevent

/**
 * Created by Isaac Iniongun on 03/07/2020.
 * For Atsam a Ikyenge project.
 */

open class LiveDataEvent<out T>(private val content: T) {

    @Suppress("MemberVisibilityCanBePrivate")
    var hasBeenHandled = false
        private set // Allow external read but not write

    /**
     * Returns the content and prevents its use again.
     */
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    /**
     * Returns the content, even if it's already been handled.
     */
    fun peekContent(): T = content
}