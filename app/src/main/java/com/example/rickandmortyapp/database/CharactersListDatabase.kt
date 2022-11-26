package com.example.rickandmortyapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rickandmortyapp.models.Result
import com.example.rickandmortyapp.utils.Cosntants.TABLE_NAME

@Database(entities = [Result::class], version = 1)
abstract class CharactersListDatabase: RoomDatabase() {
    abstract fun charactersDao(): CharactersDao

    companion object{
        fun getDatabase(context: Context) = INSTANCE ?: synchronized(this){ buildRoomDB(context) }

        @Volatile
        private var INSTANCE: CharactersListDatabase? = null

        private fun buildRoomDB(context: Context) = Room
            .databaseBuilder(context, CharactersListDatabase::class.java, TABLE_NAME)
            .build()
    }

}