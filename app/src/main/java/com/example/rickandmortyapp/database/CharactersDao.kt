package com.example.rickandmortyapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmortyapp.models.Result
import com.example.rickandmortyapp.utils.Cosntants.TABLE_NAME
import kotlinx.coroutines.flow.Flow

@Dao
interface CharactersDao {

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllArticles(): Flow<List<Result>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(vararg character: Result)
}