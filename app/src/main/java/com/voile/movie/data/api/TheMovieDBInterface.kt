package com.voile.movie.data.api

import com.voile.movie.data.vo.MovieDetails
import com.voile.movie.data.vo.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieDBInterface {
    //https://api.themoviedb.org/3/movie/popular?api_key=bad0d83fcc5038e4a9639c9e39782793&language=en-US&page=1
    //https://api.themoviedb.org/3/movie/497582?api_key=bad0d83fcc5038e4a9639c9e39782793&language=en-US
    //https://api.themoviedb.org/3/

    @GET("movie/popular")
    fun getPopularMovie(@Query("page") page: Int) : Single<MovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int) : Single<MovieDetails>
}