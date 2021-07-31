package com.cateim.cursos.android.terremotosapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cateim.cursos.android.terremotosapp.adapter.TerremotoAdapter
import com.cateim.cursos.android.terremotosapp.model.Resultado
import com.cateim.cursos.android.terremotosapp.model.Terremoto
import com.cateim.cursos.android.terremotosapp.services.TerremotoService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val terremotoService = TerremotoService()
        var terremotos = ArrayList<Terremoto>()

        val adapter = TerremotoAdapter(this, terremotos)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val terremotosRecyclerView = findViewById<RecyclerView>(R.id.terremotosRecyclerView)
        terremotosRecyclerView.adapter = adapter
        terremotosRecyclerView.layoutManager = layoutManager

        // Llamada al WS
        val call = terremotoService.obtenerTerremotosUltHora()

        call.enqueue(object : Callback<Resultado?> {
            override fun onResponse(call: Call<Resultado?>, response: Response<Resultado?>) {
                if (response.isSuccessful) {
                    val resultado = response.body()

                    if (resultado != null) {
                        terremotos.clear()
                        terremotos.addAll(resultado.terremotos)
                        adapter.notifyDataSetChanged()
                    }
                } else {
                    Toast.makeText(this@MainActivity, "Hubo un error", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<Resultado?>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.opciones, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

//        if (id == R.id.list_terremotos) {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//            return true
//        }

        if (id == R.id.map_terremotos) {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
            return true
        }

        return super.onOptionsItemSelected(item)
    }


}