package com.cateim.cursos.android.ahorcado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private val palabras = arrayOf("TOYOTA", "AUDI", "BMV", "KIA", "LADA", "PEUGOT", "RENAULT", "NISSAN")
    private var palabraSecreta = ""
    private var palabraEscondida = ""
    private var numIntentos = 1

    lateinit var ahorcadoImageView: ImageView
    lateinit var palabraTextView: TextView

    lateinit var buttonA: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ahorcadoImageView = findViewById(R.id.ahorcadoImageView)
        palabraTextView = findViewById<TextView>(R.id.palabraTextView)

        inicializarTeclado()
        inicializarJuego()
    }

    fun reiniciarJuego(view: View) {
        // val myButtonReset = view as Button
        ahorcadoImageView.setImageResource(R.drawable.ahorcado_5)
        palabraSecreta = ""
        palabraEscondida = ""
        numIntentos = 1
        inicializarJuego()
    }

    fun inicializarJuego() {
        val indice = (0..(palabras.size - 1)).random()
        palabraSecreta = palabras[indice]
        Log.d(TAG, "la palabra secreta es " + palabraSecreta)
        for (c in palabraSecreta) {
            palabraEscondida = palabraEscondida + "*"
        }

        palabraTextView.text = palabraEscondida
    }

    fun jugar(letra: Char) {
        val palabraTemp = palabraEscondida.toCharArray()
        var acertaste = false

        for (i in 0..palabraSecreta.length - 1) {
            if ( letra == palabraSecreta[i] ) {
                palabraTemp[i] = letra
                acertaste = true
            }
        }

        palabraEscondida = String(palabraTemp)


        Log.d(TAG,"palabra temporal = " + palabraEscondida)
        palabraTextView.text = palabraEscondida

        if (palabraSecreta.equals(palabraEscondida)) {
            Toast.makeText(this, "Has Ganado!", Toast.LENGTH_LONG).show()
            return
        }

        if (!acertaste && numIntentos < 5) {
            when(numIntentos) {
                1 -> {
                    ahorcadoImageView.setImageResource(R.drawable.ahorcado_6)
                }
                2 -> {
                    ahorcadoImageView.setImageResource(R.drawable.ahorcado_7)
                }
                3 -> {
                    ahorcadoImageView.setImageResource(R.drawable.ahorcado_8)
                }
                4 -> {
                    ahorcadoImageView.setImageResource(R.drawable.ahorcado_9)
                }
            }

            numIntentos++ // numIntentos = numIntentos + 1

            if (numIntentos == 5) {
                ahorcadoImageView.setImageResource(R.drawable.ahorcado_10)
                Toast.makeText(this, "Perdiste que Triste :(", Toast.LENGTH_LONG).show()
                return
            }
        }

    }

    fun inicializarTeclado() {

        val letraListener = View.OnClickListener {
            val letraButton = it as Button
            Log.d(TAG, "se ha presionado la tecla " + letraButton.text)
            val letra = letraButton.text[0]
            jugar(letra)
        }

        findViewById<Button>(R.id.buttonQ).setOnClickListener(letraListener)
        findViewById<Button>(R.id.buttonW).setOnClickListener(letraListener)
        findViewById<Button>(R.id.buttonE).setOnClickListener(letraListener)
        findViewById<Button>(R.id.buttonR).setOnClickListener(letraListener)
        findViewById<Button>(R.id.buttonT).setOnClickListener(letraListener)
        findViewById<Button>(R.id.buttonY).setOnClickListener(letraListener)
        findViewById<Button>(R.id.buttonU).setOnClickListener(letraListener)
        findViewById<Button>(R.id.buttonI).setOnClickListener(letraListener)
        findViewById<Button>(R.id.buttonO).setOnClickListener(letraListener)
        findViewById<Button>(R.id.buttonP).setOnClickListener(letraListener)
        findViewById<Button>(R.id.buttonA).setOnClickListener(letraListener)
        findViewById<Button>(R.id.buttonS).setOnClickListener(letraListener)
        findViewById<Button>(R.id.buttonD).setOnClickListener(letraListener)
        findViewById<Button>(R.id.buttonF).setOnClickListener(letraListener)
        findViewById<Button>(R.id.buttonG).setOnClickListener(letraListener)
        findViewById<Button>(R.id.buttonH).setOnClickListener(letraListener)
        findViewById<Button>(R.id.buttonJ).setOnClickListener(letraListener)
        findViewById<Button>(R.id.buttonK).setOnClickListener(letraListener)
        findViewById<Button>(R.id.buttonL).setOnClickListener(letraListener)
        findViewById<Button>(R.id.buttonZ).setOnClickListener(letraListener)
        findViewById<Button>(R.id.buttonX).setOnClickListener(letraListener)
        findViewById<Button>(R.id.buttonC).setOnClickListener(letraListener)
        findViewById<Button>(R.id.buttonV).setOnClickListener(letraListener)
        findViewById<Button>(R.id.buttonB).setOnClickListener(letraListener)
        findViewById<Button>(R.id.buttonN).setOnClickListener(letraListener)
        findViewById<Button>(R.id.buttonM).setOnClickListener(letraListener)


    }

}