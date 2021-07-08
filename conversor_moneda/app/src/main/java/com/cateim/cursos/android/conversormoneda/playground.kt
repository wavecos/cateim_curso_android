package com.cateim.cursos.android.conversormoneda

import java.math.BigDecimal

fun main() {

    val resultado = 6.96f / 6.96f

    println(resultado)

    val monto = BigDecimal(6.96)

    val conversion = monto.div(BigDecimal(6.96))
    println(conversion.toDouble())

    val esMiercoles = true

    if (!esMiercoles) {
        println("Ok media semana")
    }

}