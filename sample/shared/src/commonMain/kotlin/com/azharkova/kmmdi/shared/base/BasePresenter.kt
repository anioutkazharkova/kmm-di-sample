package com.azharkova.kmmdi.shared.base

abstract class BasePresenter<T : com.azharkova.kmmdi.shared.base.IView> :
    com.azharkova.kmmdi.shared.base.IPresenter {
    open var view: T? = null

    fun onAttachView(view: T) {
        this.view = view
    }

    fun onDetachView() {
        this.view = null
    }
}
