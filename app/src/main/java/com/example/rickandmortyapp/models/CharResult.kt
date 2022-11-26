package com.example.rickandmortyapp.models

import com.google.gson.annotations.SerializedName


data class CharResult(
    val info: Info,
    @SerializedName("results") val characters: List<Result>
)