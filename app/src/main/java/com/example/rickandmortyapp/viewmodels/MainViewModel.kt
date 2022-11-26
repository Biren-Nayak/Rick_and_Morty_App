package com.example.rickandmortyapp.viewmodels

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.database.CharactersListDatabase
import com.example.rickandmortyapp.models.Result
import com.example.rickandmortyapp.repository.RickAndMortyRepository
import com.example.rickandmortyapp.viewmodels.MainViewModel.LoadingStates.*
import kotlinx.coroutines.launch

class MainViewModel(application: Application): ViewModel() {

    enum class LoadingStates {SUCCESS, LOADING, ERROR}

    private val repository = RickAndMortyRepository(CharactersListDatabase.getDatabase(application))

    private val _status = MutableLiveData(LOADING)
    val status: LiveData<LoadingStates> = _status



    val characters: LiveData<List<Result>> = repository.characters

    private val _selectedCharacter = MutableLiveData<Result>()
    val selectedCharacter: LiveData<Result> = _selectedCharacter


    private fun fetchRepository(){
        viewModelScope.launch {
            try{
                repository.refreshCharacters()
                _status.value = SUCCESS
            }catch (e: java.lang.Exception){
                _status.value = ERROR
                Log.e(TAG, e.message?: "")
            }
        }
    }

    fun onCharacterClicked(result: Result) { _selectedCharacter.value = result }

    init { fetchRepository() }
}