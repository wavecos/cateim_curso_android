package com.cateim.cursos.android.musicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cateim.cursos.android.musicapp.adapter.CancionAdapter
import com.cateim.cursos.android.musicapp.model.Cancion
import com.cateim.cursos.android.musicapp.model.ErrorItunes
import com.cateim.cursos.android.musicapp.model.Resultado
import com.cateim.cursos.android.musicapp.service.ITunesService
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    var canciones = ArrayList<Cancion>()
    val itunesService = ITunesService()

    lateinit var cancionAdapter: CancionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Definimos el buscador de artista
        val criterioEditText = findViewById<EditText>(R.id.criterioEditText)
        findViewById<ImageButton>(R.id.searchButton).setOnClickListener {
            buscarCanciones(criterioEditText.text.toString())
        }

        // RecyclerView
        val cancionRecyclerView = findViewById<RecyclerView>(R.id.cancionRecyclerView)

        cancionAdapter = CancionAdapter(this, canciones)
        val cancionLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        cancionRecyclerView.adapter = cancionAdapter
        cancionRecyclerView.layoutManager = cancionLayoutManager

        // Toast.makeText(this, "Despues de la llamada", Toast.LENGTH_LONG).show()

    }

    fun buscarCanciones(artista: String) {
        val call = itunesService.obtenerCanciones(artista)

        // Aqui hacemos la llamada al Itunes
        call.enqueue(object : Callback<Resultado?> {
            override fun onResponse(
                call: Call<Resultado?>,
                response: Response<Resultado?>
            ) {

                if (response.isSuccessful) {
                    val resultado = response.body()

                    if (resultado != null) {
                        canciones.clear()
                        canciones.addAll(resultado.canciones)
//                        canciones = resultado.canciones

                        cancionAdapter.notifyDataSetChanged()

                        for (c in canciones) {
                            Log.d(TAG, "${c.nombreArtista}-${c.nombreAlbum}-${c.nombreCancion}-${c.genero}")
                        }
                    }

                } else {
                    val gson = Gson()
                    val errorJsonString = response.errorBody()?.string()
                    val errorItunes = gson.fromJson(errorJsonString, ErrorItunes::class.java)

                    Log.e(TAG, errorItunes.errorMessage)
                    Toast.makeText(this@MainActivity, errorItunes.errorMessage, Toast.LENGTH_LONG).show()
                }

            }

            override fun onFailure(call: Call<Resultado?>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            }
        })

    }



}