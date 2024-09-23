package edu.sam.dam2024.features.supers.presentation

import androidx.lifecycle.ViewModel
import edu.sam.dam2024.features.supers.domain.GetSuperUseCase
import edu.sam.dam2024.features.supers.domain.Super

class SuperViewModel (private val getSuperUseCase: GetSuperUseCase) : ViewModel(){

    fun viewCreated(): List<Super> {
        return getSuperUseCase.invoke()
    }

}