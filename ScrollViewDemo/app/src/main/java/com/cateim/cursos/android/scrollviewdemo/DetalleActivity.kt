package com.cateim.cursos.android.scrollviewdemo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetalleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        // Recuperar los Extras que recibimos
        val titular = intent.getStringExtra("TITULAR_KEY")
        val noticia = intent.getStringExtra("NOTICIA_KEY")
        val imagenId = intent.getIntExtra("IMAGEN_ID_KEY", 0)
        val urlNoticia = intent.getStringExtra("URL_KEY")

        // Definimos los Views
        val titularTextView = findViewById<TextView>(R.id.titularTextView)
        val bodyTextView = findViewById<TextView>(R.id.bodyTextView)
        val noticiaImageView = findViewById<ImageView>(R.id.imageView)
        // Asigno valores a los View
        titularTextView.text = titular
        bodyTextView.text = noticia
        noticiaImageView.setImageResource(imagenId)

        findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener {
            val uriNoticia = Uri.parse(urlNoticia)
            val intent = Intent(Intent.ACTION_VIEW, uriNoticia)

            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        // ....
    }
}