package com.movies.core.douban.interceptors

import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author donnieSky
 * @created_at 2018/11/26.
 * @description
 * @version
 */
class DoubanInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url()
                .newBuilder()
                .addQueryParameter(
                        "apikey",
                        "0df993c66c0c636e29ecbb5344252a4a")
                .build()
        val newRequest = request.newBuilder().url(url).build()
        return chain.proceed(newRequest)
    }
}