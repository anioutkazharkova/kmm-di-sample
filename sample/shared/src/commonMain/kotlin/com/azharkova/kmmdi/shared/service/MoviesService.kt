package com.azharkova.kmmdi.shared.service

import com.azharkova.kmmdi.shared.data.MoviesList
import com.azharkova.kmmdi.shared.network.Configuration
import com.azharkova.kmmdi.shared.network.NetworkClient

class MoviesService(private val networkClient: com.azharkova.kmmdi.shared.network.NetworkClient?) {

    suspend fun loadMovies(): com.azharkova.kmmdi.shared.data.MoviesList? {
        val url = "discover/movie?api_key=${com.azharkova.kmmdi.shared.network.Configuration.API_KEY}&page=1&sort_by=popularity.desc"
        return networkClient?.loadContentData(url)
    }

    suspend fun searchMovies(query: String): com.azharkova.kmmdi.shared.data.MoviesList? {
        val url = "search/movie?api_key=${com.azharkova.kmmdi.shared.network.Configuration.API_KEY}&page=1&query=$query"
        return networkClient?.loadContentData(url)
    }
}
