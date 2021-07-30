package com.cateim.cursos.android.terremotosapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cateim.cursos.android.terremotosapp.R
import com.cateim.cursos.android.terremotosapp.model.Terremoto

class TerremotoAdapter(val context: Context, val terremotosDataset: List<Terremoto>): RecyclerView.Adapter<TerremotoAdapter.TerremotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TerremotoViewHolder {
        val cancionView = LayoutInflater.from(context).inflate(R.layout.terremoto_item, parent, false)
        return TerremotoViewHolder(cancionView)
    }

    override fun onBindViewHolder(holder: TerremotoViewHolder, position: Int) {
        val terremoto = terremotosDataset.get(position)
        holder.textViewMagnitude.text = terremoto.nombreCancion
    }

    override fun getItemCount(): Int {
        return terremotosDataset.size
    }

    class TerremotoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textViewMagnitude: TextView
        val textViewPlace: TextView
        val textViewDate: TextView

        init {
            textViewMagnitude = itemView.findViewById(R.id.textViewMagnitude)
            textViewPlace = itemView.findViewById(R.id.textViewPlace)
            textViewDate = itemView.findViewById(R.id.textViewDate)
        }
    }

}