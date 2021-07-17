package com.cateim.cursos.android.scrollviewdemo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NoticiasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noticias)

        val titularTextView = findViewById<TextView>(R.id.titularTextView)

        titularTextView.setOnClickListener {
            // 1. Crear el Intent
            val intentDetalle = Intent(this, DetalleActivity::class.java)

            // 2. Inicializar la Actividad con el Intent creado
            startActivity(intentDetalle)
        }

        findViewById<FloatingActionButton>(R.id.phoneFloatingActionButton).setOnClickListener {
            val telefonoUri = Uri.parse("tel:+59179103573")
            val telefonoIntent = Intent(Intent.ACTION_DIAL, telefonoUri)

            startActivity(telefonoIntent)
        }

    }
}