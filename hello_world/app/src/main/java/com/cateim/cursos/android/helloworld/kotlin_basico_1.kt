package com.cateim.cursos.android.helloworld

fun main() {
    println("** Numeros en Kotlin **")
    val pi = 3.14159264 // val es usado para definir constantes o valores que no cambian
    val numDiasSemana: Byte = 7 // definición del número de días

    var interesPrestamo: Float = 3.5f // var es usado para definir variables (cambian su valor)
    interesPrestamo = 3.1f


    val salarioMinimo = 2000.0f
    val calculo = salarioMinimo * numDiasSemana
    println("En la semana existen : " + numDiasSemana + " dias")

    println("** Caracteres en Kotlin **")
    val letra: Char
    letra = 'A'

    // Se va imprimir en la consola
    println(letra)

    val tab: Char = '\t'
    val saltoLinea = '\n'
    val borrar = '\b'

    println("hola" + tab + tab + "mundo" + saltoLinea + "esta es una nueva linea")

    println("esto es un texto" + borrar)

    println("** Booleanos en Kotlin **")
    val esJueves = false

    println("hoy es jueves? " + esJueves)
    println("hoy no es jueves? " + !esJueves)

    println("** Strings en Kotlin **")
    val tweet = "Hoy es viernes 25 de Junio"
    println(tweet)

    val postFacebook = "El día de mañana sábado\ndormiré hasta las 11:00\t\tgenial!!\n\n \"el que rie al ultimo rie mejor\""

    println(postFacebook)
    println("coma en Joe\'s")

    println("** Arrays en Kotlin **")
    val autos = arrayOf("Audi", "KIA", "Land Rover", "TOYOTA", "BMW")
    println(autos.size)
    println(autos[1]) // acceder a elem de un array por medio de su indice

    println(autos[autos.size - 1])
    println(autos.last())

    println("Iteramos el array")
    for (coche in autos) {
        println(coche)
    }

    val infectados = arrayOf(100, 100, 41, 60, 254, 456, 84, 31, 220)

    // calculamos el promedio
    var total = 0
    for (x in infectados) {
        total = total + x
    }

    // CONVERSION ENTRE TIPOS DE DATOS
    val promedio = total.toFloat() / infectados.size // .toFloat() para convertir un Int a Float
    println("Promedio de Infectados = " + promedio)

    println(pi.toInt())

    println(pi.toString())

    val prom = total.div(9.3f) // total / 9.3f

    val sueldo = "453.7".toFloat()

    val ajuste = sueldo * 1.2

    println("Condiciones y if-else en kotlin")

    // Operadores de Comparacion
    // a < b
    // a > b
    // a >= b
    // a <= b
    // a == b
    // a != b

    if ( promedio > 300.0 ) {
        println("los casos se han disparado a nivel nacional")
    } else {
        println("mantengamos las medidas de bioseguridad")
    }

    println("** if-else if-else en Kotlin**")
    for (a in autos) {
        if ( a == "TOYOTA") {
            println(a + " es industria japonesa")
        } else if (a == "Land Rover") {
            println(a + " es industria inglesa")
        } else if (a == "KIA") {
            println(a + " es industria koreana")
        } else {
            println(a + " es de otro pais")
        }
    }

    if ("TOYOTA" in autos) {
        println("Toyota es una marca japonesa")
    } else {
        println("no lo encuentro")
    }


    println("** when en Kotlin**")
    for (a in autos) {
        when (a) {
            "TOYOTA" -> {
                println(a + " es industria japonesa")
            }
            "Land Rover" -> println(a + " es industria inglesa")
            "KIA" -> println(a + " es industria koreana")
            else -> println(a + " es de otro pais")
        }
    }

    println("** Loop For en Kotlin **")

    for (num in 0..100) {
        println(num)
    }

    // tabla de multiplicar del 9
    val m = 9
    for (n in 1..10) {
        println(m.toString() + " x " + n.toString() + " = " + (m*n))
    }

    for (n in 10 downTo 0) {
        println(m.toString() + " x " + n.toString() + " = " + (m*n))
    }

    // Rangos tambien estan definidos por caracteres
    for (c in 'a'..'m') {
        println(c)
    }

    println("--------------------------------------------")

    // Rangos desde String
    for (c in "Murciélago") {
        println(c)
    }

}