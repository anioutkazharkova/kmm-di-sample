package com.azharkova.kmmdi.shared.di

import com.azharkova.di.scope.ScopeType
import com.azharkova.di.util.register
import com.azharkova.di.util.resolve
import kotlinx.cinterop.ObjCClass

fun <T : Any> com.azharkova.kmmdi.shared.di.DIManager.register(clazz: ObjCClass, fabric: () -> T?) {
    appContainer.register(clazz, ScopeType.Graph, fabric)
}

fun <T : Any> com.azharkova.kmmdi.shared.di.DIManager.resolve(clazz: ObjCClass): Any? {
    return appContainer.resolve(clazz)
}
