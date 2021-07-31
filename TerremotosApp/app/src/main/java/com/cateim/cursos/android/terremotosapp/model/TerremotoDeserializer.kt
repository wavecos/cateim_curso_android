package com.cateim.cursos.android.terremotosapp.model

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type
import java.util.*

class TerremotoDeserializer : JsonDeserializer<Terremoto> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Terremoto {
        val jsonObject = json!!.asJsonObject
        val propertiesObject = jsonObject["properties"].asJsonObject
        val geometryObject = jsonObject["geometry"].asJsonObject
        val magnitude = propertiesObject["mag"].asFloat
        val place = propertiesObject["place"].asString
        val url = propertiesObject["url"].asString
        val tsunami = propertiesObject["tsunami"].asBoolean
        val type = propertiesObject["type"].asString
        val time = propertiesObject["time"].asLong
        val longitude = geometryObject["coordinates"].asJsonArray[0].asDouble
        val latitude = geometryObject["coordinates"].asJsonArray[1].asDouble

        val terremoto = Terremoto(
            magnitude,
            place,
            Date(time),
            url,
            tsunami,
            type,
            latitude,
            longitude
        )

        return terremoto
    }
}