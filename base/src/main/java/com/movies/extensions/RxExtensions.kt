package com.movies.extensions

import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.internal.functions.Functions

/**
 * @author donnieSky
 * @created_at 2018/8/21.
 * @description
 * @version
 */
fun <T> Observable<T>.emptySubscribe() = subscribe(Functions.emptyConsumer(), Functions.ERROR_CONSUMER)

fun <T> Flowable<T>.emptySubscribe() = subscribe(Functions.emptyConsumer(), Functions.ERROR_CONSUMER)

fun <T> Observable<T>.toFlowable() = toFlowable(BackpressureStrategy.LATEST)

fun <T> emptyFlowableList() = Flowable.just(emptyList<T>())