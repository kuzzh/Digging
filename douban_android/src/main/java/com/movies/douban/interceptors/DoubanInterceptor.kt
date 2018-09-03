package com.movies.douban.interceptors

import com.movies.douban.Douban.Companion.API_KEY
import com.movies.douban.Douban.Companion.API_KEY_PARAM
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author donnieSky
 * @created_at 2018/9/3.
 * @description
 * @version
 */
class DoubanInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url()
                .newBuilder()
                .addQueryParameter(API_KEY_PARAM, API_KEY)
                .build()
        val newRequest = request.newBuilder().url(url).build()
        return chain.proceed(newRequest)
    }
}