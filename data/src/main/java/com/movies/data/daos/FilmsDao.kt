package com.movies.data.daos


import androidx.room.Dao
import androidx.room.Query
import com.movies.data.entities.Film
import io.reactivex.Flowable
import io.reactivex.Maybe

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
@Dao
abstract class FilmsDao : EntityDao<Film> {

    @Query("SELECT * FROM films WHERE id in (:ids)")
    abstract fun getFilmsWithIds(ids: List<Long>): Flowable<List<Film>>

    @Query("SELECT * FROM films WHERE id = :id")
    abstract fun getFlowableFilmWithId(id: Long): Flowable<Film>

    @Query("SELECT * FROM films WHERE id = :id")
    abstract fun getMaybeFilmWithId(id: Long): Maybe<Film>

    @Query("SELECT * FROM films WHERE id = :id")
    abstract fun getFilmWithId(id: Long): Film?

    @Query("SELECT * FROM films WHERE douban_id = :doubanId")
    abstract fun getFilmWithDoubanId(doubanId: String): Film?

    @Query("SELECT douban_id FROM films WHERE id = :id")
    abstract fun getDoubanIdForId(id: Long): String?

    @Query("SELECT id FROM films WHERE douban_id = :doubanId")
    abstract fun getIdForDoubanId(doubanId: String): Long?
}