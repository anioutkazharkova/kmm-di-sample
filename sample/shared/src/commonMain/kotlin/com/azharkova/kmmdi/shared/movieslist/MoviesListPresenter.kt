package com.azharkova.kmmdi.shared.movieslist

import com.azharkova.kmmdi.shared.base.BasePresenter
import com.azharkova.kmmdi.shared.data.MoviesItem

interface IMoviesListPresenter {
    var view: com.azharkova.kmmdi.shared.movieslist.IMoviesListView?

    fun setup(items: List<com.azharkova.kmmdi.shared.data.MoviesItem>)
}

class MoviesListPresenter :
    com.azharkova.kmmdi.shared.base.BasePresenter<com.azharkova.kmmdi.shared.movieslist.IMoviesListView>(),
    com.azharkova.kmmdi.shared.movieslist.IMoviesListPresenter {
    override var view: com.azharkova.kmmdi.shared.movieslist.IMoviesListView? = null

    override fun setup(items: List<com.azharkova.kmmdi.shared.data.MoviesItem>) {
        this.view?.setup(items)
    }
}
