package com.cateim.cursos.android.scrollviewdemo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.cateim.cursos.android.scrollviewdemo.model.Noticia
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NoticiasActivity : AppCompatActivity() {

    lateinit var noticias: Array<Noticia>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noticias)

        // Definimos las noticias

        val noticia1 = Noticia("FBF acepta adelantar partido de Vinto Palmaflor y Guabirá",
        """La Dirección de Competiciones de la Federación Boliviana de Fútbol (FBF) aceptó la solicitud de Mcepal Vinto Palmaflor de adelantar su partido de este domingo 25 de julio ante Guabirá, en el estadio Félix Capriles para las 13:00 y en cumplimiento de la fecha 11 del Torneo Único de la División Profesional. Inicialmente estaba programado para las 19:30.

El comunicado fue emitido la tarde de este martes y debido a las restricciones establecidas por el Comité de Operaciones y Emergencias Departamental (COED) de no permitir la circulación de personas y motorizados desde las 16:00.

La solicitud fue consensuada y aceptada por la FBF y la empresa dueña de los derechos de televisión. Ahora, la afición podrá disfrutar el encuentro en un horario poco típico para el fútbol dominical en la Llajta.""",
            R.drawable.noticia1, "https://www.lostiempos.com/deportes/futbol/20210720/fbf-acepta-adelantar-partido-vinto-palmaflor-guabira")

        val noticia2 = Noticia("""Biden hace balance de sus primeros seis meses: "Estamos cumpliendo promesas"""",
        """El presidente de Estados Unidos, Joe Biden, reunió este martes a su gabinete al cumplirse los primeros seis meses de su llegada a la Casa Blanca para hacer balance de su gestión y aseguró que su Gobierno está "cumpliendo las promesas" que hizo al país.

Al inicio de esta reunión, y en presencia de los medios de comunicación, Biden celebró datos como la creación de tres millones de empleos, "más de los que ninguna otra Administración" ha logrado en los primeros seis meses de mandato, y subrayó los esfuerzos para luchar contra la pandemia.

Aprovechó este momento para insistir en pedir a los ciudadanos que se inmunicen contra la covid-19 porque "todas las muertes" por esta enfermedad se están registrando entre personas no vacunadas.

La directora de los Centros para el Control y Prevención de Enfermedades de EE.UU. (CDC, en inglés), Rochelle Walensky, aseguró hoy durante una audiencia ante un comité del Senado que la variante delta representa ya el 83 % de los casos secuenciados de covid-19 en Estados Unidos.

Además de la pandemia y la economía, Biden subrayó que en estos meses ha trabajado en restaurar el liderazgo internacional de EE.UU y habló de otras cuestiones de su agenda que como el derecho al voto, la inmigración, la reforma policial y la lucha contra la delincuencia.""",
            R.drawable.noticia2, "https://www.lostiempos.com/actualidad/mundo/20210720/biden-hace-balance-sus-primeros-seis-meses-estamos-cumpliendo-promesas")

        val noticia3 = Noticia("Bancada de CC descarta brindar descargos ante Comisión de Ética por viaje a EEUU",
        """La bancada de la alianza Comunidad Ciudadana (CC), en la Cámara de Diputados, descartó brindar los descargos correspondientes, ante la Comisión de Ética, por el viaje que hicieron junto a un grupo de legisladores de Creemos a Estados Unidos para denunciar ante organismos internacionales la presunta vulneración de derechos humanos en Bolivia.

Hacia fines de junio, la denuncia de la Confederación Sindical Única de Trabajadores Campesinos de Bolivia (Csutcb) fue formalizada y posteriormente admitida ante esa comisión legislativa que ahora investiga presuntas irregularidades que se habrían cometido.

En rueda de prensa, el diputado Marcelo Pedrazas, expresó su rechazo al proceso que se sigue en su contra, además de sus colegas, y consideró que solo se busca “perseguir” a los opositores.

“Queremos dejar establecido que no le vamos a dar ninguna explicación a nadie, peor al masismo de lo que hemos hecho nosotros en el uso de nuestras atribuciones constitucionales”, afirmó.

El viaje en cuestión a Estados Unidos se hizo a fines de abril. La delegación de diputados y senadores de las dos bancadas opositoras sostuvieron reuniones con el secretario de la Organización de Estados Americanos (OEA), Luis Almagro; con la Comisión Interamericana de Derechos Humanos (CIDH) y con el director de Human Rigths Watch, José Miguel Vivanco.""",
            R.drawable.noticia3, "https://www.lostiempos.com/actualidad/pais/20210720/bancada-cc-descarta-brindar-descargos-comision-etica-viaje-eeuu")

        val titular1TextView = findViewById<TextView>(R.id.titular1TextView)
        titular1TextView.text = noticia1.titular

        val titular2TextView = findViewById<TextView>(R.id.titular2TextView)
        titular2TextView.text = noticia2.titular

        val titular3TextView = findViewById<TextView>(R.id.titular3TextView)
        titular3TextView.text = noticia3.titular

        titular1TextView.setOnClickListener {
            mostrarDetalle(noticia1)
        }

        titular2TextView.setOnClickListener {
            mostrarDetalle(noticia2)
        }

        titular3TextView.setOnClickListener {
            mostrarDetalle(noticia3)
        }

        findViewById<FloatingActionButton>(R.id.phoneFloatingActionButton).setOnClickListener {
            val telefonoUri = Uri.parse("tel:+59179103573")
            val telefonoIntent = Intent(Intent.ACTION_DIAL, telefonoUri)

            startActivity(telefonoIntent)
        }
    }

    fun mostrarDetalle(noticia: Noticia) {
        // 1. Crear el Intent
        val intentDetalle = Intent(this, DetalleActivity::class.java)

        // 2. Colocar los extras
        intentDetalle.putExtra("TITULAR_KEY", noticia.titular)
        intentDetalle.putExtra("NOTICIA_KEY", noticia.noticia)
        intentDetalle.putExtra("IMAGEN_ID_KEY", noticia.imagenId)
        intentDetalle.putExtra("URL_KEY", noticia.url)

        // 3. Inicializar la Actividad con el Intent creado
        startActivity(intentDetalle)
    }

}