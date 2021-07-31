package com.cateim.cursos.android.terremotosapp.adapter

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cateim.cursos.android.terremotosapp.R
import com.cateim.cursos.android.terremotosapp.WebActivity
import com.cateim.cursos.android.terremotosapp.model.Terremoto
import java.text.SimpleDateFormat

class TerremotoAdapter(val context: Context, val terremotosDataset: List<Terremoto>): RecyclerView.Adapter<TerremotoAdapter.TerremotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TerremotoViewHolder {
        val terremotoView = LayoutInflater.from(context).inflate(R.layout.terremoto_item, parent, false)
        return TerremotoViewHolder(terremotoView)
    }

    override fun onBindViewHolder(holder: TerremotoViewHolder, position: Int) {
        val terremoto = terremotosDataset.get(position)
        holder.textViewMagnitud.text = "${terremoto.magnitude}"

        //
        if (terremoto.magnitude > 1.5) {
            holder.textViewMagnitud.setTextColor(context.resources.getColor(R.color.terremotoRed, null))
        }

        holder.textViewLugar.text = terremoto.place

        // Date format
        val dateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
        var dateStr = ""
        if (terremoto.date != null) {
            dateStr = dateFormat.format(terremoto.date)
        }
        holder.textViewFecha.text = dateStr

        // click al webactivity
        holder.itemView.setOnClickListener {
            val intent = Intent(context, WebActivity::class.java)
            intent.putExtra("TERREMOTO_URL", terremoto.url)

            context.startActivity(intent)
        }

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