package com.cateim.cursos.android.terremotosapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cateim.cursos.android.terremotosapp.R
import com.cateim.cursos.android.terremotosapp.model.Terremoto

class TerremotoAdapter(val context: Context, val terremotosDataset: List<Terremoto>): RecyclerView.Adapter<TerremotoAdapter.TerremotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TerremotoViewHolder {
        val terremotoView = LayoutInflater.from(context).inflate(R.layout.terremoto_item, parent, false)
        return TerremotoViewHolder(terremotoView)
    }

    override fun onBindViewHolder(holder: TerremotoViewHolder, position: Int) {
        val terremoto = terremotosDataset.get(position)
        holder.textViewMagnitud.text = terremoto.nombreCancion
    }

    override fun getItemCount(): Int {
        return terremotosDataset.size
    }

    class TerremotoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textViewMagnitud: TextView
        val textViewLugar: TextView
        val textViewFecha: TextView

        init {
            textViewMagnitud = itemView.findViewById(R.id.textViewMagnitud)
            textViewLugar = itemView.findViewById(R.id.textViewLugar)
            textViewFecha = itemView.findViewById(R.id.textViewFecha)
        }
    }

}