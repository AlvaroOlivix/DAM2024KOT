package edu.sam.dam2024.features.supers.presentation

import edu.sam.dam2024.features.supers.data.SuperDataRepository
import edu.sam.dam2024.features.supers.data.remote.SuperMockRemoteDataSource
import edu.sam.dam2024.features.supers.domain.GetSuperUseCase
import edu.sam.dam2024.features.supers.domain.GetSupersUseCase

class SuperFactory {
    fun buildViewModel(): SuperViewModel = SuperViewModel(
        GetSupersUseCase(
            SuperDataRepository(
                SuperMockRemoteDataSource()
            )
        )
    )
}