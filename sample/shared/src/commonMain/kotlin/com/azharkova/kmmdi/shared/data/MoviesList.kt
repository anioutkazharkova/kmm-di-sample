package com.azharkova.kmmdi.shared.data

import kotlinx.serialization.Serializable

@Serializable
data class MoviesList(val results: List<com.azharkova.kmmdi.shared.data.MoviesItem>)
