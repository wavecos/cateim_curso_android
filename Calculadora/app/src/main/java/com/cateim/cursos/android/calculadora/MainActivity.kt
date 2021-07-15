package com.cateim.cursos.android.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private var num1 = 0.0
    private var num2 = 0.0
    private var operacion = Operacion.NO_OPERACION

    lateinit var displayTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayTextView = findViewById(R.id.displayTextView)

        inicializarBotones()
    }

    fun inicializarBotones() {
        findViewById<Button>(R.id.digit0Button).setOnClickListener { digitPresionado("0") }
        findViewById<Button>(R.id.digit1Button).setOnClickListener { digitPresionado("1") }
        findViewById<Button>(R.id.digit2Button).setOnClickListener { digitPresionado("2") }
        findViewById<Button>(R.id.digit3Button).setOnClickListener { digitPresionado("3") }
        findViewById<Button>(R.id.digit4Button).setOnClickListener { digitPresionado("4") }
        findViewById<Button>(R.id.digit5Button).setOnClickListener { digitPresionado("5") }
        findViewById<Button>(R.id.digit6Button).setOnClickListener { digitPresionado("6") }
        findViewById<Button>(R.id.digit7Button).setOnClickListener { digitPresionado("7") }
        findViewById<Button>(R.id.digit8Button).setOnClickListener { digitPresionado("8") }
        findViewById<Button>(R.id.digit9Button).setOnClickListener { digitPresionado("9") }
        findViewById<Button>(R.id.decimalButton).setOnClickListener { digitPresionado(".") }

        // Operaciones
        findViewById<Button>(R.id.opDivButton).setOnClickListener { operacionPresionado(Operacion.DIVIDIR) }
        findViewById<Button>(R.id.opMulButton).setOnClickListener { operacionPresionado(Operacion.MULTIPLICAR) }
        findViewById<Button>(R.id.opResButton).setOnClickListener { operacionPresionado(Operacion.RESTAR) }
        findViewById<Button>(R.id.opSumButton).setOnClickListener { operacionPresionado(Operacion.SUMAR) }

        // Boton Igual
        findViewById<Button>(R.id.calcularButton).setOnClickListener { resolverCalculo() }

        // Boton Clear
        findViewById<Button>(R.id.clearButton).setOnClickListener { limpiar() }
    }


    fun digitPresionado(num: String) {
        if (displayTextView.text == "0" && num != ".") {
            displayTextView.text = "${num}"
        } else {
            displayTextView.text = "${displayTextView.text}${num}"
        }

        if (operacion == Operacion.NO_OPERACION) {
            num1 = displayTextView.text.toString().toDouble()
        } else {
            num2 = displayTextView.text.toString().toDouble()
        }

    }

    fun operacionPresionado(op: Operacion) {
        this.operacion = op
        num1 = displayTextView.text.toString().toDouble()
        displayTextView.text = "0"
    }

    fun resolverCalculo() {
        var resultado = 0.0
        when (operacion) {
            Operacion.DIVIDIR -> resultado = num1 / num2
            Operacion.MULTIPLICAR -> resultado = num1 * num2
            Operacion.RESTAR -> resultado = num1 - num2
            Operacion.SUMAR -> resultado = num1 + num2
        }

        if (resultado.isInfinite()) {
            displayTextView.text = "Es Infinito!"
        } else {
            val decimalFormat = DecimalFormat("#.###")
            displayTextView.text = if ("${resultado}".endsWith(".0")) { "${resultado}".replace(".0", "") } else { decimalFormat.format(resultado) }
        }

    }

    fun limpiar() {
        displayTextView.text = "0"
        num1 = 0.0
        num2 = 0.0
    }


}