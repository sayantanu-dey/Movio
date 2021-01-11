package com.voile.movie.data.repository

enum class Status{
    RUNNING,
    SUCCESS,
    FAILED
}

class NetworkState(val status: Status, val msg: String) {
    companion object{
        val LOADED: NetworkState
        val LOADING: NetworkState
        val ERROR: NetworkState
        val EOF: NetworkState

        init {
            LOADED = NetworkState(Status.SUCCESS,"Success")
            LOADING = NetworkState(Status.RUNNING,"running")
            ERROR = NetworkState(Status.FAILED,"Something went wrong")
            EOF = NetworkState(Status.FAILED,"You have reached the end")
        }

    }
}