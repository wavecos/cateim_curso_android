package com.cateim.cursos.android.conversormoneda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultadoTextView = findViewById<TextView>(R.id.resultadoTextView)
        val montoEditText = findViewById<EditText>(R.id.montoEditText)
        val convertirButton = findViewById<Button>(R.id.convertirButton)

        convertirButton.setOnClickListener {

            val monto = montoEditText.text.toString().toFloat()

            val conversion = monto / 6.96

            resultadoTextView.text = conversion.toString() + " USD"
        }



    }
}