package com.example.rickandmortyapp.repository

import com.example.rickandmortyapp.database.CharactersDao
import com.example.rickandmortyapp.network.RickAndMortyApi
import javax.inject.Inject

class RickAndMortyRepository @Inject constructor(
    private val charactersDao: CharactersDao,
    private val rickAndMortyApi: RickAndMortyApi
    ){

    fun getAllCharacters() = charactersDao.getAllArticles()

    suspend fun refreshCharacters(){
        val characters = rickAndMortyApi.getResult().characters
        charactersDao.insertCharacter(*characters.toTypedArray())
    }


}
