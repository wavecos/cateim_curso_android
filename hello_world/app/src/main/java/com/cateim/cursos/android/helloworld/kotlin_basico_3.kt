package com.cateim.cursos.android.helloworld

fun main() {
    // Notacion camel case vs sneake case
    val calculoInteresCompuesto = 0.0
    val calculo_interes_compuesto = 0.0

    // Creamos objetos a partir de la definicion de una Clase
    val toyota = Carro()
    toyota.marca = "TOYOTA"
    toyota.modelo = "Land Cruiser"
    toyota.anio = 1984

    val tesla = Carro()
    tesla.marca = "TESLA"
    tesla.modelo = "X3"
    tesla.anio = 2017

    val audi = Carro()
    tesla.marca = "AUDI"
    tesla.modelo = "Brilliant"
    tesla.anio = 1990

    val stockCoches = arrayOf(toyota, tesla, audi)

    // Que coches son antes del año 2000 en tu stock?
    for (c in stockCoches) {
        if (c.anio < 2000) {
            println(c.marca + " - " + c.modelo)
        }
    }

    // Constructores en Clases
    val emp1 = Empleado("Juan Perez", 3600.0, "451236554", "Mecanico")
    val emp2 = Empleado("Maria Soliz", 6100.0, "45122211", "Secretaria")
    val emp3 = Empleado("Pedro Picasso", 4500.0, "4365188854", "Vendedor")
    val emp4 = Empleado("Juana Godines", 5850.0, "4554202021", "Mecanico")

    emp2.genero = "F"
    emp4.genero = "F"

    val nominaEmpleados = arrayOf(emp1, emp2, emp3, emp4)

    for (e in nominaEmpleados) {
        incrementoSueldo(e.nombre, e.sueldo)
    }

    println("-----------------------------------------------------")
    val fido = Perro("Fido", "San Bernardo", 15)
    val hitler = Perro("Hitler", "Dobberman", 9)

    fido.comer(300)
    fido.ladrar()
    println("Fido energia = " + fido.energia)

    hitler.comer(1500)

    hitler.atacar(fido)

    fido.morir()

    println("Fido energia = " + fido.energia)
    println("Hitler energia = " + hitler.energia)

    val garfield = Gato("Garfield", "siames")

    garfield.maullar()

    garfield.comer(300)

    garfield.morir()

}

class Carro {
    var marca: String = ""
    var modelo: String = ""
    var anio: Int = 0
}

class Empleado(var nombre: String, var sueldo: Double, var documento: String, var cargo: String) {
    var genero: String = "M"
}

class Perro(var nombre: String, var raza: String, var edad: Int): SerVivo() {
    fun ladrar() {
        println("Wof Wof!!")
    }

    fun atacar(otro: Perro) {
        if (energia > 10) {
            println("Grrrr")
            energia = energia - 10
            otro.energia = otro.energia - 20
        }
    }
}

class Gato(var nombre: String, var raza: String): SerVivo() {
    fun maullar() {
        println("Miau!!")
    }

}

open class SerVivo {
    var energia = 100

    fun comer(calorias: Int) {
        energia = energia + calorias
    }

    fun morir() {
        energia = 0
    }
}


// Se recomienda usar la notacion Camel Case