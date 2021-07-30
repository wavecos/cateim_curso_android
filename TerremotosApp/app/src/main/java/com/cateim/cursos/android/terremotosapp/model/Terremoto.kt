package com.cateim.cursos.android.terremotosapp.model

import com.google.gson.annotations.SerializedName
import java.util.*

class Terremoto(
    var magnitude: Float,
    var place: String,
    var date: Date,
    var url: String,
    var isTsunami: Boolean,
    var type: String,
    var latitude: Double,
    var longitude: Double,
) {

}