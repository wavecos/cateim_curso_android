package com.cateim.cursos.android.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Crear vistas programaticamente
        val context = applicationContext

        this.title = "Hola Mundo App"

        val miTexto = TextView(this)
        miTexto.text = "Que tal"
        miTexto.width = 300

        val button = Button


        val mensaje: TextView = findViewById(R.id.mensajeTextView)
        val saludar: Button = findViewById(R.id.saludarButton)

        saludar.setOnClickListener {
            mensaje.text = "Hola\nHumanos!!"
        }

        Log.d(TAG, "Dentro del onCreate")
        Log.e(TAG, "Ha ocurrido un error")
    }
}