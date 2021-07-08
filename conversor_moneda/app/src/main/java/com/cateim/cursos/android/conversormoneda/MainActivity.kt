package com.cateim.cursos.android.conversormoneda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.core.widget.addTextChangedListener
import java.lang.ArithmeticException
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    val tipo_cambio = 6.96


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultadoTextView = findViewById<TextView>(R.id.resultadoTextView)
        val montoEditText = findViewById<EditText>(R.id.montoEditText)
        val convertirButton = findViewById<Button>(R.id.convertirButton)

        montoEditText.addTextChangedListener {
            Log.d(TAG, "texto introducido")
            convertirButton.isEnabled = true
        }

        convertirButton.setOnClickListener {
            if (montoEditText.text.isEmpty()) {
                Toast.makeText(this, "El monto no puede estar vacio", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

//            if (!montoEditText.text.isDigitsOnly()) {
//                Toast.makeText(this, "El monto tiene que ser un numero", Toast.LENGTH_LONG).show()
//                return@setOnClickListener
//            }

            try {
                // Intenta ejecutar esto
                val monto = montoEditText.text.toString().toBigDecimal()
                val conversion = monto.div(tipo_cambio.toBigDecimal())
                resultadoTextView.text = conversion.toString() + " USD"
            } catch (e: NumberFormatException) {
                // He capturado la excepcion
                Toast.makeText(this, "El monto tiene que ser un numero", Toast.LENGTH_LONG).show()
            } catch (z: ArithmeticException) {
                Toast.makeText(this, "No se puede realizar una division entre 0", Toast.LENGTH_LONG).show()
            }
        }

    }
}