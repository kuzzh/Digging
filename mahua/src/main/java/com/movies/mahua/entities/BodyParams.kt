package com.movies.mahua.entities

/**
 * @author donnieSky
 * @created_at 2018/9/12.
 * @description
 * @version
 */
data class BodyParams(
        val appInfo: AppInfo? = AppInfo(),
        val cip: String? = "127.0.0.1",
        val ctime: Long? = System.currentTimeMillis() / 1000,
        val uid: Long? = 14357495,
        val token: String? = "mb_token:14357495:40ef8e7acf3d5c175ef046b328d61688",
        val fetchAll: Boolean? = false,
        val searchContent: String? = null,
        val currentPage: Int? = null,
        val pageSize: Int? = null,
        val entry: Int? = null,
        val data: DataParam? = null,
        val columnId: Int? = null
)

data class AppInfo(
        val modelName: Int? = 4,
        val packageId: String? = "7",
        val terminal: Int? = 2,
        val uuid: String? = "3e1eebf750b322df",
        val version: String? = "1.5.2"
)

data class DataParam(
        val videoId: Int? = -1,
        val videoInfoId: Long? = null
)