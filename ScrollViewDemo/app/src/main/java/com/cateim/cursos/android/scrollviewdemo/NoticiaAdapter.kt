package com.cateim.cursos.android.scrollviewdemo

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cateim.cursos.android.scrollviewdemo.model.Noticia

class NoticiaAdapter(val context: Context, val dataset: Array<Noticia>) : RecyclerView.Adapter<NoticiaAdapter.NoticiaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticiaViewHolder {
        val noticiaView = LayoutInflater.from(context).inflate(R.layout.noticia_item, parent, false)
        return NoticiaViewHolder(noticiaView)
    }

    override fun onBindViewHolder(holder: NoticiaViewHolder, position: Int) {
        val noticia = dataset.get(position)
        holder.noticiaTitularTextView.text = noticia.titular
        holder.titularImageView.setImageResource(noticia.imagenId)
        // Click
        holder.verMasTextView.setOnClickListener {
            // 1. Crear el Intent
            val intentDetalle = Intent(context, DetalleActivity::class.java)

            // 2. Colocar los extras
            intentDetalle.putExtra("TITULAR_KEY", noticia.titular)
            intentDetalle.putExtra("NOTICIA_KEY", noticia.noticia)
            intentDetalle.putExtra("IMAGEN_ID_KEY", noticia.imagenId)
            intentDetalle.putExtra("URL_KEY", noticia.url)

            // 3. Inicializar la Actividad con el Intent creado
            context.startActivity(intentDetalle)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    class NoticiaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val noticiaTitularTextView: TextView
        val verMasTextView: TextView
        val titularImageView: ImageView

        init {
            noticiaTitularTextView = itemView.findViewById(R.id.noticiaTitularTextView)
            verMasTextView = itemView.findViewById(R.id.verMasTextView)
            titularImageView = itemView.findViewById(R.id.titularImageView)
        }
    }
}