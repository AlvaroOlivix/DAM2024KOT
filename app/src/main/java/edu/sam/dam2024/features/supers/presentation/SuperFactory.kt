package edu.sam.dam2024.features.supers.presentation

import android.content.Context
import edu.sam.dam2024.app.data.api.ApiClient
import edu.sam.dam2024.features.supers.data.SuperDataRepository
import edu.sam.dam2024.features.supers.data.local.SuperXmlLocalDataSource
import edu.sam.dam2024.features.supers.data.remote.SuperApiRemoteDataSource
import edu.sam.dam2024.features.supers.data.remote.SuperMockRemoteDataSource
import edu.sam.dam2024.features.supers.data.remote.SuperService
import edu.sam.dam2024.features.supers.domain.GetSuperUseCase
import edu.sam.dam2024.features.supers.domain.GetSupersUseCase

class SuperFactory(private val context: Context) {
   // private val superMockRemoteDataSource = SuperMockRemoteDataSource()
   // private val superLocal = SuperXmlLocalDataSource(context)
    private val superDataRepository = SuperDataRepository(getSuperApiRemoteDataSource())
    private val getSuperUseCase = GetSuperUseCase(superDataRepository)
    private val getSupersUseCase = GetSupersUseCase(superDataRepository)

    fun buildViewModel(): SuperListViewModel {
        return SuperListViewModel(getSupersUseCase)
    }

    fun buildSuperDetailViewModel(): SuperDetailViewModel {
        return SuperDetailViewModel(getSuperUseCase)
    }

    private fun getSuperApiRemoteDataSource(): SuperApiRemoteDataSource {
        val superService = ApiClient.provideSuperService()
        return SuperApiRemoteDataSource(superService)
    }
}