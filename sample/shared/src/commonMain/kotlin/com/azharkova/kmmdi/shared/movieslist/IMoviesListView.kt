package com.azharkova.kmmdi.shared.movieslist

import com.azharkova.kmmdi.shared.base.IView
import com.azharkova.kmmdi.shared.data.MoviesItem

interface IMoviesListView : com.azharkova.kmmdi.shared.base.IView {
    var interactor: com.azharkova.kmmdi.shared.movieslist.IMoviesListInteractor?

    fun setup(items: List<com.azharkova.kmmdi.shared.data.MoviesItem>)
}
