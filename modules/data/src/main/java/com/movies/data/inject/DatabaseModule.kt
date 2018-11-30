package com.movies.data.inject

import android.content.Context
import android.os.Debug
import androidx.room.Room
import com.movies.data.DB
import com.movies.data.utils.DatabaseTransactionRunner
import com.movies.data.utils.RoomTransactionRunner
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/11/28.
 * @description
 * @version
 */
@Module
class DatabaseModule {

    @Provides
    fun provideTransactionRunner(db: DB): DatabaseTransactionRunner = RoomTransactionRunner(db)

    @Singleton
    @Provides
    fun provideDatabase(context: Context): DB {
        val builder = Room.databaseBuilder(
                context,
                DB::class.java,
                "dou_qi_media.db"
        ).fallbackToDestructiveMigration()
        if (Debug.isDebuggerConnected()) {
            builder.allowMainThreadQueries()
        }
        return builder.build()
    }

    @Provides
    fun provideVideoDao(db: DB) = db.videoDao()

}