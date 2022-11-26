package com.example.rickandmortyapp.network

import com.example.rickandmortyapp.utils.Cosntants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RickAndMortyApiService {

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val rickAndMortyApi: RickAndMortyApi by lazy {
        retrofit.create(RickAndMortyApi::class.java)
    }
}
