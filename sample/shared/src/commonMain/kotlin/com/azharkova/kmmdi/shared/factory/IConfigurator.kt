package com.azharkova.kmmdi.shared.factory

import com.azharkova.kmmdi.shared.base.IInteractor
import com.azharkova.kmmdi.shared.base.IView
import com.azharkova.kmmdi.shared.movieslist.IMoviesListView
import com.azharkova.kmmdi.shared.movieslist.MoviesListConfigurator

interface IConfigurator {
    fun create(view: com.azharkova.kmmdi.shared.base.IView): com.azharkova.kmmdi.shared.base.IInteractor?
}

class ModuleConfig {
    companion object {
        val instance = com.azharkova.kmmdi.shared.factory.ModuleConfig()
    }

    fun config(view: com.azharkova.kmmdi.shared.base.IView): com.azharkova.kmmdi.shared.base.IInteractor? {
        if (view is com.azharkova.kmmdi.shared.movieslist.IMoviesListView) {
            return com.azharkova.kmmdi.shared.movieslist.MoviesListConfigurator.instance.create(view)
        }
        return null
    }
}
