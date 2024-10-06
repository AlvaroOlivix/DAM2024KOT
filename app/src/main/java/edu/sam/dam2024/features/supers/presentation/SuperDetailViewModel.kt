package edu.sam.dam2024.features.supers.presentation

import edu.sam.dam2024.features.supers.domain.GetSuperUseCase
import edu.sam.dam2024.features.supers.domain.Super

class SuperDetailViewModel(private val getSuperUseCase: GetSuperUseCase) {

    fun viewCreated(superId: String): Super? {
        return getSuperUseCase.invoke(superId)
    }
}