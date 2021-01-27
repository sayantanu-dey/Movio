package com.voile.movie.data.api

import okhttp3.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val API_KEY = "<API KEY>"
const val BASE_URL = "https://api.themoviedb.org/3/"

const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w500/"

const val FIRST_PAGE = 1;
const val POST_PER_PAGE = 20;

object TheMovieDBClient {
    fun getClient(): TheMovieDBInterface{
        val requestInterceptor = Interceptor(fun(chain: Interceptor.Chain): Response {
            val url: HttpUrl = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter("api_key", API_KEY)
                .build()

            val request: Request = chain.request()
                .newBuilder()
                .url(url)
                .build()

            return chain.proceed(request);
        })

        val okHttpClient:OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .connectTimeout(60,TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TheMovieDBInterface::class.java)

    }
}
