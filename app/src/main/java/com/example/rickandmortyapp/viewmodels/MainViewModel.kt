package com.example.rickandmortyapp.viewmodels

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.models.Result
import com.example.rickandmortyapp.repository.RickAndMortyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: RickAndMortyRepository): ViewModel() {


    val characters: LiveData<List<Result>> = repository.characters

    private val _selectedCharacter = MutableLiveData<Result>()
    val selectedCharacter: LiveData<Result> = _selectedCharacter


    private fun fetchRepository(){
        viewModelScope.launch {
            try{
                repository.refreshCharacters()
            }catch (e: java.lang.Exception){
                Log.e(TAG, e.message?: "")
            }
        }
    }

    fun onCharacterClicked(result: Result) { _selectedCharacter.value = result }

    init { fetchRepository() }
}