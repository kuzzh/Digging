package com.movies.inject

import javax.inject.Qualifier

/**
 * @author donnieSky
 * @created_at 2018/8/21.
 * @description
 * @version
 */
@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class Douban

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class IMDB

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class DYTT