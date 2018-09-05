package com.movies.data

import androidx.room.TypeConverter
import org.threeten.bp.Instant
import org.threeten.bp.format.DateTimeFormatter

/**
 * @author donnieSky
 * @created_at 2018/9/5.
 * @description
 * @version
 */
object DouqiTypeConverters {

    private val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME

    @TypeConverter
    @JvmStatic
    fun toInstant(value: Long?) = value?.let { Instant.ofEpochMilli(it) }

    @TypeConverter
    @JvmStatic
    fun fromInstant(date: Instant?) = date?.toEpochMilli()

}