package com.azharkova.kmmdi.shared.movieslist

import com.azharkova.kmmdi.shared.base.BaseInteractor
import com.azharkova.kmmdi.shared.base.IInteractor
import com.azharkova.kmmdi.shared.data.MoviesItem
import com.azharkova.kmmdi.shared.di.DIManager
import com.azharkova.kmmdi.shared.service.MoviesService
import com.azharkova.kmmdi.shared.util.uiDispatcher
import kotlinx.coroutines.launch

interface IMoviesListInteractor : com.azharkova.kmmdi.shared.base.IInteractor {
    var presenter: IMoviesListPresenter?
    fun loadMovies()
}

class MoviesListInteractor :
    BaseInteractor<com.azharkova.kmmdi.shared.movieslist.IMoviesListView>(uiDispatcher),
    IMoviesListInteractor {
    private var moviesService: MoviesService? = null
    override var presenter: IMoviesListPresenter? = null

    private var moviesList: ArrayList<com.azharkova.kmmdi.shared.data.MoviesItem> = arrayListOf()

    override fun setup(di: com.azharkova.kmmdi.shared.di.DIManager) {
        this.moviesService = di.resolve<com.azharkova.kmmdi.shared.service.MoviesService>(com.azharkova.kmmdi.shared.service.MoviesService::class) as? com.azharkova.kmmdi.shared.service.MoviesService
        print(moviesService)
    }

    override fun loadMovies() {
        scope.launch {
            print(moviesService == null)
            val result = moviesService?.loadMovies()?.results
            moviesList = arrayListOf()
            moviesList.addAll(result ?: arrayListOf())
            presenter?.setup(moviesList)
        }
    }
}
