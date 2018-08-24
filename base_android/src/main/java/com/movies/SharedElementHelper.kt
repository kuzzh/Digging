package com.movies

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.fragment.app.FragmentTransaction
import java.lang.ref.WeakReference

/**
 * @author donnieSky
 * @created_at 2018/8/21.
 * @description
 * @version
 */
class SharedElementHelper {

    private val sharedElementViews = mutableMapOf<WeakReference<View>, String?>()

    fun addSharedElement(view: View, name: String? = null) {
        sharedElementViews[WeakReference(view)] = name ?: view.transitionName
    }

    fun applyToTransaction(ft: FragmentTransaction) {
        for ((viewRef, customTransitionName) in sharedElementViews) {
            viewRef.get()?.apply {
                ft.addSharedElement(this, customTransitionName!!)
            }
        }
    }

    fun applyToIntent(activity: Activity): Bundle? {
        return ActivityOptionsCompat.makeSceneTransitionAnimation(
                activity,
                *sharedElementViews.map { Pair(it.key.get(), it.value) }.toList().toTypedArray()
        ).toBundle()
    }

    fun isEmpty(): Boolean = sharedElementViews.isEmpty()
}