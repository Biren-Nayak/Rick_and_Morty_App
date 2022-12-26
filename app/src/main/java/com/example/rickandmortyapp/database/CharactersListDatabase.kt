package com.example.rickandmortyapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rickandmortyapp.models.Result

@Database(entities = [Result::class], version = 1, exportSchema = false)
abstract class CharactersListDatabase: RoomDatabase() {
    abstract fun charactersDao(): CharactersDao
}