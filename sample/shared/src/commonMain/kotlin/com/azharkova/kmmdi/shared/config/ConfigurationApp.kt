package com.azharkova.kmmdi.shared.config

import com.azharkova.di.scope.ScopeType
import com.azharkova.kmmdi.shared.di.DIManager
import com.azharkova.kmmdi.shared.network.NetworkClient
import com.azharkova.kmmdi.shared.service.MoviesService

class ConfigurationApp {
    val appContainer: com.azharkova.kmmdi.shared.di.DIManager =
        com.azharkova.kmmdi.shared.di.DIManager()

    init {
        setup()
    }

    fun setup() {
        appContainer.addToScope(
            ScopeType.Container,
            com.azharkova.kmmdi.shared.network.NetworkClient::class
        ) {
            com.azharkova.kmmdi.shared.network.NetworkClient()
        }
        appContainer.addToScope(
            ScopeType.Container,
            com.azharkova.kmmdi.shared.service.MoviesService::class
        ) {
            val nc = appContainer.resolve<com.azharkova.kmmdi.shared.network.NetworkClient>(com.azharkova.kmmdi.shared.network.NetworkClient::class) as? com.azharkova.kmmdi.shared.network.NetworkClient
            com.azharkova.kmmdi.shared.service.MoviesService(nc)
        }
    }
}
