package com.azharkova.kmmdi.shared.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseInteractor<T : com.azharkova.kmmdi.shared.base.IView>(private val coroutineContext: CoroutineContext) {
    protected lateinit var scope: com.azharkova.kmmdi.shared.base.ModuleCoroutineScope

    fun attachView() {
        scope = com.azharkova.kmmdi.shared.base.ModuleCoroutineScope(coroutineContext)
    }

    fun detachView() {
        scope.viewDetached()
    }
}

class ModuleCoroutineScope(
    context: CoroutineContext
) : CoroutineScope {

    private var onViewDetachJob = Job()
    override val coroutineContext: CoroutineContext = context + onViewDetachJob

    fun viewDetached() {
        onViewDetachJob.cancel()
    }
}
