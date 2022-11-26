package com.example.rickandmortyapp.models


import androidx.room.*
import com.example.rickandmortyapp.database.LocationTypeConverter
import com.example.rickandmortyapp.utils.Cosntants.TABLE_NAME
import com.google.gson.annotations.SerializedName


@Entity(tableName = TABLE_NAME)
@TypeConverters(LocationTypeConverter::class)
data class Result(
    @PrimaryKey val id: Int,
    val created: String,
    @ColumnInfo(defaultValue = "") val episode: List<String>?,
    val gender: String,
    @SerializedName("image") val imgUrl: String,
    @ColumnInfo(defaultValue = "") val location: Location,
    val name: String,
    @ColumnInfo(defaultValue = "") val origin: Origin,
    val species: String,
    val status: String,
    @ColumnInfo(defaultValue = "") val type: String,
    val url: String
)