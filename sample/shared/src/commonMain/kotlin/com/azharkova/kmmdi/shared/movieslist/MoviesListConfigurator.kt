package com.azharkova.kmmdi.shared.movieslist

import com.azharkova.kmmdi.shared.base.IInteractor
import com.azharkova.kmmdi.shared.base.IView
import com.azharkova.kmmdi.shared.factory.IConfigurator

class MoviesListConfigurator : com.azharkova.kmmdi.shared.factory.IConfigurator {
    companion object {
        val instance = com.azharkova.kmmdi.shared.movieslist.MoviesListConfigurator()
    }

    override fun create(view: com.azharkova.kmmdi.shared.base.IView): com.azharkova.kmmdi.shared.base.IInteractor? {
        val interactor: com.azharkova.kmmdi.shared.movieslist.IMoviesListInteractor =
            com.azharkova.kmmdi.shared.movieslist.MoviesListInteractor()
        val presenter = com.azharkova.kmmdi.shared.movieslist.MoviesListPresenter()
        interactor.presenter = presenter
        presenter.view = view as? com.azharkova.kmmdi.shared.movieslist.IMoviesListView
        return interactor
    }
}
