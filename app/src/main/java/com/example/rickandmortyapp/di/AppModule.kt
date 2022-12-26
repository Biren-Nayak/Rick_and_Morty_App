package com.example.rickandmortyapp.di

import android.app.Application
import androidx.room.Room
import com.example.rickandmortyapp.database.CharactersDao
import com.example.rickandmortyapp.database.CharactersListDatabase
import com.example.rickandmortyapp.network.RickAndMortyApi
import com.example.rickandmortyapp.repository.RickAndMortyRepository
import com.example.rickandmortyapp.utils.Cosntants.BASE_URL
import com.example.rickandmortyapp.utils.Cosntants.TABLE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun myRepoImpl(dao: CharactersDao, api: RickAndMortyApi) = RickAndMortyRepository(dao, api)


    @Provides
    @Singleton
    fun myApiImpl() = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
        .create(RickAndMortyApi::class.java)




    @Provides
    @Singleton
    fun myDaoImpl(database: CharactersListDatabase) = database.charactersDao()


    @Provides
    @Singleton
    fun myDatabaseImpl(application: Application) = Room
        .databaseBuilder(application, CharactersListDatabase::class.java, TABLE_NAME)
        .build()
}