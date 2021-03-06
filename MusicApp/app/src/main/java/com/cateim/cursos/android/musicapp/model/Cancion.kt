package com.cateim.cursos.android.musicapp.model

import com.google.gson.annotations.SerializedName

class Cancion(
    @SerializedName("artistName")
    var nombreArtista: String,
    @SerializedName("collectionName")
    var nombreAlbum: String,
    @SerializedName("trackName")
    var nombreCancion: String,
    @SerializedName("artworkUrl100")
    var imagenUrl: String,
    @SerializedName("primaryGenreName")
    var genero: String,
    @SerializedName("previewUrl")
    var cancionUrl: String
) {

}