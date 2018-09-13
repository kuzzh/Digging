package com.movies.mahua.interceptors

import com.movies.mahua.utils.AES
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author donnieSky
 * @created_at 2018/9/12.
 * @description
 * @version
 */
class MahuaInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val newRequest = request.newBuilder()
                .addHeader("accesstoken", AES.randomAccessToken())
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .build()
        return chain.proceed(newRequest)
    }
}