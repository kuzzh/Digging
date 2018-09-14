package com.movies.data.repositories.films

import com.movies.data.repositories.seeds.SeedRepository
import com.movies.data.repositories.seeds.SeedRepositoryImpl
import com.movies.inject.DOUBAN
import dagger.Binds
import dagger.Module

/**
 * @author donnieSky
 * @created_at 2018/9/6.
 * @description
 * @version
 */
@Module
abstract class FilmsModule {

    @Binds
    abstract fun bind(source: FilmRepositoryImpl): FilmRepository

    @Binds
    @DOUBAN
    abstract fun bind(source: DoubanFilmDataSource): FilmDataSource

    @Binds
    abstract fun bind(source: SeedRepositoryImpl): SeedRepository

}