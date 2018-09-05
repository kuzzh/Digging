package com.movies.data.entities

import androidx.room.*
import com.movies.data.PaginatedEntry

/**
 * @author donnieSky
 * @created_at 2018/9/5.
 * @description
 * @version
 */
@Entity(tableName = "in_theaters",
        indices = [Index(value = ["entry_id"], unique = true)],
        foreignKeys = [
            ForeignKey(entity = Film::class,
                    parentColumns = arrayOf("id"),
                    childColumns = arrayOf("entry_id"),
                    onUpdate = ForeignKey.CASCADE,
                    onDelete = ForeignKey.CASCADE)
        ])
data class InTheaterEntry(
        @PrimaryKey(autoGenerate = true)
        override val id: Long = 0,
        @ColumnInfo(name = "entry_id")
        override val entryId: Long,
        @ColumnInfo(name = "page")
        override val page: Int,
        @ColumnInfo(name = "page_order")
        val pageOrder: Int
) : PaginatedEntry