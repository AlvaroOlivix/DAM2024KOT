package edu.sam.dam2024.app.data.api

import edu.sam.dam2024.features.supers.data.remote.SuperService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val BASE_URL_API = "https://akabab.github.io/superhero-api/api/"

    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    fun provideSuperService(): SuperService {
        return provideRetrofit().create(SuperService::class.java)
    }

}