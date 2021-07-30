package com.cateim.cursos.android.terremotosapp.services

import com.cateim.cursos.android.terremotosapp.model.Resultado
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class TerremotoService {

    val terremotoAPI: TerremotoAPI

    // https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        terremotoAPI = retrofit.create(TerremotoAPI::class.java)
    }

    fun obtenerTerremotosUltHora(): Call<Resultado> {
        return terremotoAPI.terremotosUltimaHora()
    }

    fun obtenerTerremotosUltDia(): Call<Resultado> {
        return terremotoAPI.terremotosUltimaDia()
    }

    fun obtenerTerremotosUltSemana(): Call<Resultado> {
        return terremotoAPI.terremotosUltimaSemana()
    }

    fun obtenerTerremotosUltMes(): Call<Resultado> {
        return terremotoAPI.terremotosUltimaMes()
    }

    interface TerremotoAPI {
        @GET("all_hour.geojson")
        fun terremotosUltimaHora(): Call<Resultado>

        @GET("all_day.geojson")
        fun terremotosUltimaDia(): Call<Resultado>

        @GET("all_week.geojson")
        fun terremotosUltimaSemana(): Call<Resultado>

        @GET("all_month.geojson")
        fun terremotosUltimaMes(): Call<Resultado>
    }


}