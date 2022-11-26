package com.example.rickandmortyapp.database

import androidx.room.TypeConverter
import com.example.rickandmortyapp.models.Location
import com.example.rickandmortyapp.models.Origin
import org.json.JSONObject

class LocationTypeConverter {
    private val name = "name"
    private val url = "url"

    @TypeConverter
    fun fromLocation(location: Location): String = JSONObject().apply {
            put(name, " ${location.name}")
            put(url, " ${location.url}")
        }.toString()


    @TypeConverter
    fun toLocation(location: String): Location = JSONObject(location).run { Location( getString(name), getString(url) ) }


    @TypeConverter
    fun fromOrigin(origin: Origin): String = JSONObject().apply {
            put(name, " ${origin.name}")
            put(url, " ${origin.url}")
        }.toString()


    @TypeConverter
    fun toOrigin(origin: String): Origin = JSONObject(origin).run { Origin( getString(name), getString(url) ) }

    @TypeConverter
    fun fromEpiList(list: List<String>): String = JSONObject().apply {
        put("list", list)
    }.toString()

    @TypeConverter
    fun tomEpiList(list: String): List<String> = JSONObject(list).run { list.split(",") }

}