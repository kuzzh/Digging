package com.movies.douqi.extensions

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

/**
 * @author donnieSky
 * @created_at 2018/9/3.
 * @description
 * @version
 */
inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}