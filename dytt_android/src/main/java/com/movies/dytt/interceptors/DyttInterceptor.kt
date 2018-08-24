package com.movies.dytt.interceptors

import com.movies.dytt.BuildConfig
import com.movies.dytt.DYTT
import com.movies.utils.Digest
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author donnieSky
 * @created_at 2018/8/23.
 * @description
 * @version
 */
class DyttInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val currentTime = System.currentTimeMillis() / 1000
        val content = StringBuilder()
        content.append(BuildConfig.ENCRYPT_KEY)
                .append("${DYTT.X_HEADER_REQUEST_TIMESTAMP}=$currentTime")
                .append("${DYTT.X_HEADER_REQUEST_IMEI}=${BuildConfig.X_HEADER_REQUEST_IMEI}")
        val key = Digest().md5Hex(content.toString())
        val newRequest = request.newBuilder()
                .addHeader(DYTT.X_HEADER_REQUEST_TIMESTAMP, "$currentTime")
                .addHeader(DYTT.X_HEADER_REQUEST_IMEI, BuildConfig.X_HEADER_REQUEST_IMEI)
                .addHeader(DYTT.X_HEADER_REQUEST_KEY, key).build()
        return chain.proceed(newRequest)
    }
}