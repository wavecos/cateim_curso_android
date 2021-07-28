package com.cateim.cursos.android.musicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.cateim.cursos.android.musicapp.model.Cancion
import com.cateim.cursos.android.musicapp.service.ITunesService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itunesService = ITunesService()

        val call = itunesService.obtenerCanciones("hello")

        call.enqueue(object : Callback<List<Cancion>?> {
            override fun onResponse(
                call: Call<List<Cancion>?>,
                response: Response<List<Cancion>?>
            ) {

                if (response.isSuccessful) {
                    val canciones = response.body()
                    for (c in canciones!!) {
                        Log.d(TAG, c.trackName)
                    }
                } else {

                }

            }

            override fun onFailure(call: Call<List<Cancion>?>, t: Throwable) {

            }
        })


    }
}