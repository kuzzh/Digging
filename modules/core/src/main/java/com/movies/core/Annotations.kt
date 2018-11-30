package com.movies.core

import javax.inject.Qualifier
import javax.inject.Scope

/**
 * @author donnieSky
 * @created_at 2018/8/21.
 * @description
 * @version
 */
@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class DOUBAN

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class MAHUA

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class DYTT

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class NBA

@Retention(AnnotationRetention.RUNTIME)
@Scope
@MustBeDocumented
annotation class FragmentScope