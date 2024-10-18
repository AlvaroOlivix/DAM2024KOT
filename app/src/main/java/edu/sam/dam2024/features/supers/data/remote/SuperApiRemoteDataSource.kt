package edu.sam.dam2024.features.supers.data.remote

import edu.sam.dam2024.features.supers.domain.Super

class SuperApiRemoteDataSource(private val superService: SuperService) {

    suspend fun getSupers(): List<Super> {
        val response = superService.requestSupers()
        if (response.isSuccessful) {
            return response.body() ?: emptyList()
        } else {
            // Manejar el error de la respuesta
            return emptyList()
        }
    }

}