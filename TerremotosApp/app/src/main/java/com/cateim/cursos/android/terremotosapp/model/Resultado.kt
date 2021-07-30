package com.cateim.cursos.android.terremotosapp.model

import com.google.gson.annotations.SerializedName

class Resultado(
    @SerializedName("features")
    var terremotos: List<Terremoto>
) {
}