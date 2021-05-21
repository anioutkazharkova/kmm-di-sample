package com.azharkova.kmmdi.androidApp.ui

import com.azharkova.kmmdi.androidApp.App
import com.azharkova.kmmdi.shared.base.IView
import com.azharkova.kmmdi.shared.di.DIManager
import java.lang.ref.WeakReference
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

class Interactors<T : Any>(private val clazz: KClass<T>, private val view: com.azharkova.kmmdi.shared.base.IView, private val container: com.azharkova.kmmdi.shared.di.DIManager = App.container) :
    ReadWriteProperty<Any?, T?> {
    private var wref: WeakReference<T>? = null

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T?) {
        wref = value?.let { WeakReference(it) }
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T? {
        if (wref == null) {
            wref = WeakReference(container.resolve(view) as? T)
        }
        return wref?.get()
    }
}

// simply weakify
public inline fun <reified T : Any> interactors(view: com.azharkova.kmmdi.shared.base.IView) = Interactors(T::class, view)
