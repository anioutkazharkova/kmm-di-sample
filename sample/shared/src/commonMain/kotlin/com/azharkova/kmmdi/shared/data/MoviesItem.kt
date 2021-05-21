package com.azharkova.kmmdi.shared.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class MoviesItem() {
    var id: Long = 0
    var title: String? = ""
    var overview: String? = ""
    @SerialName("poster_path")
    var posterPath: String? = ""

    @SerialName("release_date")
    var releaseDate: String? = ""

    fun imagePath(): String = "http://image.tmdb.org/t/p/w300$posterPath"
}
