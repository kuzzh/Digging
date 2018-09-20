package com.movies.mahua.entities

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * @author donnieSky
 * @created_at 2018/9/12.
 * @description
 * @version
 */
data class VideosResult(
        val success: Boolean,
        val data: List<Video>? = null
)

data class VideoInfoResult(
        val success: Boolean,
        val data: Video? = null
)

data class Video(
        val id: Long,
        val code: String,
        val type: Int,
        val title: String,
        val director: String,
        val staring: String,
        val doubanScore: Double,
        val imdbScore: Double,
        val intro: String,
        val episodeState: Int,
        val episodeTotalCount: Int,
        val episodeUploadCount: Int,
        val playCount: Long,
        val coverTime: Int,
        val coverUrl: String,
        val coverHUrl: String,
        val createUser: String? = null,
        @SerializedName("gmtCreateStr")
        val createTime: String? = null,
        val playScore: Int,
        val downloadScore: Int,
        val playTimeLength: Long,
        val videoClassifyList: List<String>? = null,
        val classifyType: String,
        val tag: Int,
        val tagName: String,
        val tagSource: String,
        val videoList: List<Episode>? = null,
        val years: Int? = null,
        val keywords: String
)

data class Episode(
        val id: Long,
        val title: String,
        val sortNum: Int,
        val m3u8PlayUrl: String,
        val m3u8Format: M3u8Format? = null,
        val duration: Long,
        val formatExtra: Map<String, FormatExtra>? = null
) {
    fun generateStableId(): Long {
        return Objects.hash(m3u8Format!!::class, id).toLong()
    }
}

data class M3u8Format(
        val free: String? = null,
        val `480P`: String? = null,
        val `720P`: String? = null,
        val `1080P`: String? = null
)

data class FormatExtra(
        val duration: Long,
        val size: Long
)