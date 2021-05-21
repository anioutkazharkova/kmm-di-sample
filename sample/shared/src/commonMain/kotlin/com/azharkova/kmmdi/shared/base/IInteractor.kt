package com.azharkova.kmmdi.shared.base

import com.azharkova.kmmdi.shared.di.DIManager

interface IInteractor {
    fun setup(di: com.azharkova.kmmdi.shared.di.DIManager)

    fun attachView()

    fun detachView()
}
