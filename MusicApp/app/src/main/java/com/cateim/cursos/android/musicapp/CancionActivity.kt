package com.cateim.cursos.android.musicapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class CancionActivity : AppCompatActivity() {

    lateinit var player: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cancion)

        val imagenUrl = intent.getStringExtra("IMAGE_URL")
        val cancionNombre = intent.getStringExtra("CANCION_NOMBRE")
        val cancionUrl = intent.getStringExtra("CANCION_URL")

        Picasso.get()
            .load(imagenUrl)
            .into(findViewById<ImageView>(R.id.coverImageView))

        findViewById<TextView>(R.id.tracktextView).text = cancionNombre

        findViewById<ImageButton>(R.id.playButton).setOnClickListener {
            player = MediaPlayer()

            player.setDataSource(cancionUrl)
            player.prepare()
            player.start()
        }

    }
}