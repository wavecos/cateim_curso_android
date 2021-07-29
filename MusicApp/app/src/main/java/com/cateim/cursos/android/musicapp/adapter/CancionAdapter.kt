package com.cateim.cursos.android.musicapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cateim.cursos.android.musicapp.R
import com.cateim.cursos.android.musicapp.model.Cancion
import com.squareup.picasso.Picasso

class CancionAdapter(val context: Context, val cancionesDataset: List<Cancion>): RecyclerView.Adapter<CancionAdapter.CancionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CancionViewHolder {
        val cancionView = LayoutInflater.from(context).inflate(R.layout.item_cancion, parent, false)
        return CancionViewHolder(cancionView)
    }

    override fun onBindViewHolder(holder: CancionViewHolder, position: Int) {
        val cancion = cancionesDataset.get(position)
        holder.cancionTextView.text = cancion.nombreCancion

        // Para la imagen del album
        Picasso.get()
            .load(cancion.imagenUrl)
            .into(holder.albumImageView)
    }

    override fun getItemCount(): Int {
        return cancionesDataset.size
    }

    class CancionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val cancionTextView: TextView
        val albumImageView: ImageView

        init {
            cancionTextView = itemView.findViewById(R.id.cancionTextView)
            albumImageView = itemView.findViewById(R.id.albumImageView)
        }
    }

}