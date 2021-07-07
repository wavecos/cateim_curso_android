package com.cateim.cursos.android.helloworld

fun main() {

    saludar()
    println("------------")
    saludar()
    saludar()
    println("------------")
    hola("Juan")
    println("------------")
    incrementoSueldo("Juan", 5000.0)
    incrementoSueldo("Maria", 6000.50)
    println("------------")
    println("El area del circulo es = " + areaCirculo(2.5f) + " u^2")
    println("El area del triangulo es = " + areaTriangulo(52.0f, 15.0f) + " u^2")


    println("** break/continue en kotlin **")

    val resultado = 67.0 % 5.0 // el operador % (modulo) calcula el residuo de una division
    println(resultado)

    for (x in 0..100) {
        if (x == 54) {
            continue
        }

        if ( x % 2 == 0) {
            println(x)
        }

        if (x == 78) {
            break
        }
    }


}

// Una funcion que solo realiza una accion se le conoce tambien como Método
fun saludar() {
    println("Hola humanos")
    println("Chao")
}

// Funciones/Metodos con parámetros
fun hola(nombre: String) {
    println("Que tal " + nombre)
}

// Funciones/Metodos con múltiples parámetros
fun incrementoSueldo(nombre: String, sueldo: Double) {
    val incremento = sueldo * 1.20
    println(nombre + " tu incremento salarial fue de " + incremento)
}

// Funciones que devuelven un valor
fun areaCirculo(radio: Float): Double {
    val pi = 3.141592
    val area = pi * radio * radio
    return area
}

fun areaTriangulo(base: Float, altura: Float) = (base * altura) / 2




