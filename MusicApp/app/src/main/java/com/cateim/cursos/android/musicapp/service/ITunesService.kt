package com.cateim.cursos.android.musicapp.service

import com.cateim.cursos.android.musicapp.model.Cancion
import com.cateim.cursos.android.musicapp.model.Resultado
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class ITunesService {

    val iTunesAPI: ITunesAPI

    // https://itunes.apple.com/search?term=beatles&entity=song&limit=10

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://itunes.apple.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        iTunesAPI = retrofit.create(ITunesAPI::class.java)
    }

    fun obtenerCanciones(artista: String): Call<Resultado> {
        val call = iTunesAPI.buscarCanciones(artista, "song", 10)
        return call
    }

    interface ITunesAPI {
        @GET("/search")
        fun buscarCanciones(@Query("term") artista: String, @Query("entity") tipo: String, @Query("limit") limite: Int): Call<Resultado>
    }


}