package edu.sam.dam2024.features.supers.presentation

import edu.sam.dam2024.features.supers.data.remote.SuperDataRepository
import edu.sam.dam2024.features.supers.data.remote.SuperMockRemoteDataSource
import edu.sam.dam2024.features.supers.domain.GetSuperUseCase

class SuperFactory {
    fun buildViewModel(): SuperViewModel = SuperViewModel(
        GetSuperUseCase(
            SuperDataRepository(
                SuperMockRemoteDataSource()
            )
        )
    )
}