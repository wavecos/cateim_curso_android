package com.cateim.cursos.android.calculadora

import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

fun main() {

    // Manejo de Strings (avanzado)

    // String Templates
    val nombre = "Juan"
    val apellido = "Perez"
    val edad = 34

    val nombreCompleto = nombre + " " + apellido + " - " + edad

    println(nombreCompleto)
    // usando String templates
    val nombreCompleto2 = "$nombre $apellido - $edad"
    println(nombreCompleto2)

    // usando expresiones
    println("El incremento salarial del 15% de 5000 Bs es = ${5000 * 1.15}")
    println("La edad de $nombre en 5 años sera ${edad + 5}")
    val radio = 5.7
    println("El area de la semi-circunferencia cuyo radio es $radio es igual a ${(3.14159265 * radio * radio) / 2} metros^2")

    val empleado1 = Empleado("Pedro Cisneros", Cargo.MEDICO, 6700.65, 40)
    val empleado2 = Empleado("Yolanda Ramos", Cargo.SECRETARIA, 500.00, 57)

    val empleados = arrayOf(empleado1, empleado2)

    for (e in empleados) {
        if (e.edad > 50) {
            println("El empleado ${e.nombre} con cargo ${e.cargo} tiene un incremento de ${if (e.salario < 1000) e.salario * 1.5 else e.salario * 1.2}" )
        } else {
            println("El empleado ${e.nombre} con cargo ${e.cargo} su ajuste de sueldo es ${e.salario / 2}" )
        }
    }

    // Raw String
    val path = "C:\\usuarios\\alfredo"
    println(path)

    // Notacion de Triple comilla - Triple-quoted notation
    val path2 = """C:\usuarios\alfredo"""
    println(path2)

    val frase = """El que rie al ultimo rie mejor 
        |"anomimo" 
        |1745""".trimMargin()

    println(frase)

    val noticia = """La Misión en Bolivia $ $edad ${edad * 3} de la Oficina de la Alta Comisionada de Naciones Unidas para los Derechos Humanos expresó hoy su rechazo a los requerimientos fiscales a medios de 
        >comunicación de los Yungas.
                    >“La Misión rechaza los requerimientos fiscales a medios de comunicación de la región de los Yungas que han dado cobertura a los conflictos en los que 
                    >lamentablemente perdió la vida un policía y 
                    >otro resultó herido”, señala una publicación en su cuenta de Twitter. 
                    >Asimismo, recuerdan que la reserva de la fuente es un derecho protegido por el marco internacional de los derechos humanos y además se trata de una garantía fundamental 
                    >para proteger la labor de la prensa y salvaguardar el derecho de la sociedad a recibir información de interés público. """.trimMargin(">")

    println(noticia)

    // String.format()
    val texto = "el nombre es %s y su edad es %d años"
    println(texto.format(empleado1.nombre, empleado1.edad))

    val texto2 = "la velocidad del cohete es %e mt/seg".format(450287632.663366363663)
    println(texto2)

    // Formatters
    // NumberFormat
    val deudaAnualBolivia = BigDecimal("7452654.4674")

    val decimalFormat = DecimalFormat("#,###.00")
    println(decimalFormat.format(deudaAnualBolivia))

    // Format currency
    val boliviaLocale = Locale("es", "BO")
    val franciaLocale = Locale("fr", "FR")
    val monedaFormat = NumberFormat.getCurrencyInstance(franciaLocale)
    println(monedaFormat.format(deudaAnualBolivia))

}

enum class Cargo {
    GERENTE,
    SECRETARIA,
    MEDICO
}

class Empleado(var nombre: String, var cargo: Cargo, var salario: Double, var edad: Int) {}