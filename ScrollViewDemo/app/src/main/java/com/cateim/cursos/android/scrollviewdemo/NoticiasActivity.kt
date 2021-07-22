package com.cateim.cursos.android.scrollviewdemo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cateim.cursos.android.scrollviewdemo.model.Noticia
import com.cateim.cursos.android.scrollviewdemo.servicio.NoticiaService
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NoticiasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noticias)

        val noticiasService = NoticiaService()
        val noticiasDataset = noticiasService.obtenerNoticias()

        // RecyclerView
        val noticiasRecyclerView = findViewById<RecyclerView>(R.id.noticiasRecyclerView)

        val noticiaAdapter = NoticiaAdapter(this,noticiasDataset)
        val noticiaLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        noticiasRecyclerView.adapter = noticiaAdapter
        noticiasRecyclerView.layoutManager = noticiaLayoutManager

        findViewById<FloatingActionButton>(R.id.phoneFloatingActionButton).setOnClickListener {
            val telefonoUri = Uri.parse("tel:+59179103573")
            val telefonoIntent = Intent(Intent.ACTION_DIAL, telefonoUri)

            startActivity(telefonoIntent)
        }
    }

    fun mostrarDetalle(noticia: Noticia) {
        // 1. Crear el Intent
        val intentDetalle = Intent(this, DetalleActivity::class.java)

        // 2. Colocar los extras
        intentDetalle.putExtra("TITULAR_KEY", noticia.titular)
        intentDetalle.putExtra("NOTICIA_KEY", noticia.noticia)
        intentDetalle.putExtra("IMAGEN_ID_KEY", noticia.imagenId)
        intentDetalle.putExtra("URL_KEY", noticia.url)

        // 3. Inicializar la Actividad con el Intent creado
        startActivity(intentDetalle)
    }

}