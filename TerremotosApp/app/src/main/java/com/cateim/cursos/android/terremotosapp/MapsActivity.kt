package com.cateim.cursos.android.terremotosapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.cateim.cursos.android.terremotosapp.databinding.ActivityMapsBinding
import com.cateim.cursos.android.terremotosapp.model.Resultado
import com.cateim.cursos.android.terremotosapp.model.Terremoto
import com.cateim.cursos.android.terremotosapp.services.TerremotoService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


        // Terremotos
        val terremotoService = TerremotoService()
        var terremotos = ArrayList<Terremoto>()

        // Llamada al WS
        val call = terremotoService.obtenerTerremotosUltDia()

        call.enqueue(object : Callback<Resultado?> {
            override fun onResponse(call: Call<Resultado?>, response: Response<Resultado?>) {
                if (response.isSuccessful) {
                    val resultado = response.body()

                    if (resultado != null) {
                        terremotos.clear()
                        terremotos.addAll(resultado.terremotos)

                        for (t in terremotos) {
                            val latitude = t.latitude
                            val longitude = t.longitude

                            val titulo = "${t.magnitude} - ${t.place}"

                            val ubicacion = LatLng(latitude, longitude)
                            val terremotoMarker = MarkerOptions().position(ubicacion).title(titulo)
                            mMap.addMarker(terremotoMarker)
                        }
                    }
                } else {
                    Toast.makeText(this@MapsActivity, "Hubo un error", Toast.LENGTH_LONG).show()
                }

            }

            override fun onFailure(call: Call<Resultado?>, t: Throwable) {
                Toast.makeText(this@MapsActivity, t.message, Toast.LENGTH_LONG).show()
            }
        })





    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val cocha = LatLng(-17.387684, -66.161789)
        mMap.addMarker(MarkerOptions().position(cocha).title("Cochabamba"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cocha))
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.opciones, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if (id == R.id.list_terremotos) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            return true
        }

        return super.onOptionsItemSelected(item)
    }

}