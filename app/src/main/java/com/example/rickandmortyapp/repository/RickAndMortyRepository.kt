package com.example.rickandmortyapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.rickandmortyapp.database.CharactersDao
import com.example.rickandmortyapp.models.Result
import com.example.rickandmortyapp.network.RickAndMortyApi
import javax.inject.Inject

class RickAndMortyRepository @Inject constructor(
    private val charactersDao: CharactersDao,
    private val rickAndMortyApi: RickAndMortyApi

    ){

    val characters: LiveData<List<Result>> = charactersDao.getAllArticles().asLiveData()

    suspend fun refreshCharacters(){
        val characters = rickAndMortyApi.getResult().characters
        charactersDao.insertCharacter(*characters.toTypedArray())
    }


}
