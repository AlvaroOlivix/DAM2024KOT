package edu.sam.dam2024.features.supers.presentation

import android.content.Context
import edu.sam.dam2024.features.supers.data.SuperDataRepository
import edu.sam.dam2024.features.supers.data.local.SuperXmlLocalDataSource
import edu.sam.dam2024.features.supers.data.remote.SuperMockRemoteDataSource
import edu.sam.dam2024.features.supers.domain.GetSuperUseCase
import edu.sam.dam2024.features.supers.domain.GetSupersUseCase

class SuperFactory(private val context: Context) {
    private val superMockRemoteDataSource = SuperMockRemoteDataSource()
    private val superLocal = SuperXmlLocalDataSource(context)
    private val superDataRepository = SuperDataRepository(superMockRemoteDataSource, superLocal)
    private val getSuperUseCase = GetSuperUseCase(superDataRepository)
    private val getSupersUseCase = GetSupersUseCase(superDataRepository)

    fun getSupersListViewModel(): SupersListViewModel {
    return SupersListViewModel(getSupersUseCase)

    }
}