package com.example.rickandmortyapp.network

import com.example.rickandmortyapp.models.CharResult
import com.example.rickandmortyapp.utils.Cosntants.CHARACTER
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET(CHARACTER)
    suspend fun getResult(): CharResult
}