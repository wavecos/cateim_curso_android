package com.cateim.cursos.android.musicapp.model

import com.google.gson.annotations.SerializedName

class Resultado(
    var resultCount: Int,
    @SerializedName("results")
    var canciones: List<Cancion>
) {
}