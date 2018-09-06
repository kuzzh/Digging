package com.movies.data

import android.content.Context
import android.os.Debug
import androidx.room.Room
import com.movies.data.repositories.films.FilmsModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/9/5.
 * @description
 * @version
 */
@Module(includes = [FilmsModule::class])
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): DouqiDatabase {
        val builder = Room.databaseBuilder(context, DouqiDatabase::class.java, "dou_qi_films.db")
                .fallbackToDestructiveMigration()
        if (Debug.isDebuggerConnected()) {
            builder.allowMainThreadQueries()
        }
        return builder.build()
    }

    @Provides
    fun provideDatabaseTransactionRunner(db: DouqiDatabase): DatabaseTransactionRunner = RoomTransactionRunner(db)

    @Provides
    fun provideFilmDao(db: DouqiDatabase) = db.filmDao()

    @Provides
    fun provideInTheaterDao(db: DouqiDatabase) = db.inTheaterDao()

    @Provides
    fun provideLastRequestDao(db: DouqiDatabase) = db.lastRequestDao()

}