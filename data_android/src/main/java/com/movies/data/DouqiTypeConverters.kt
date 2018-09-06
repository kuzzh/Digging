package com.movies.data

import androidx.room.TypeConverter
import com.movies.data.entities.Request
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

    @TypeConverter
    @JvmStatic
    fun toRequest(value: String) = Request.values().first { it.tag == value }

    @TypeConverter
    @JvmStatic
    fun fromRequest(request: Request) = request.tag

}