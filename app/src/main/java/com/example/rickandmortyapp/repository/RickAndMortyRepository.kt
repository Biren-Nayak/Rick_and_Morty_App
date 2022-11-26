package com.example.rickandmortyapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.rickandmortyapp.database.CharactersListDatabase
import com.example.rickandmortyapp.models.Result
import com.example.rickandmortyapp.network.RickAndMortyApiService

class RickAndMortyRepository(private val database: CharactersListDatabase){

    private val dao = database.charactersDao()

    val characters: LiveData<List<Result>> = dao.getAllArticles().asLiveData()


    suspend fun refreshCharacters(){
        val characters = RickAndMortyApiService.rickAndMortyApi.getResult().characters
        dao.insertCharacter(*characters.toTypedArray())
    }



}
