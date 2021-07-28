package com.cateim.cursos.android.musicapp.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cateim.cursos.android.musicapp.model.Cancion

class CancionAdapter(val context: Context, val cancionesDataset: Array<Cancion>): RecyclerView.Adapter<CancionAdapter.CancionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CancionViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CancionViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class CancionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

}