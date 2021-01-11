package com.voile.movie.ui.singlemovie

import androidx.lifecycle.LiveData
import com.voile.movie.data.api.TheMovieDBInterface
import com.voile.movie.data.repository.MovieDetailsNetworkDataSource
import com.voile.movie.data.repository.NetworkState
import com.voile.movie.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository(private val apiService: TheMovieDBInterface){

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable,movieId: Int):LiveData<MovieDetails>{
        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService,compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieDetailsResponse
    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState;
    }

}