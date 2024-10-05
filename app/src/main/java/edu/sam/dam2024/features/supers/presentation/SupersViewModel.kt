package edu.sam.dam2024.features.supers.presentation

import androidx.lifecycle.ViewModel
import edu.sam.dam2024.features.supers.domain.GetSupersUseCase
import edu.sam.dam2024.features.supers.domain.Super

class SupersViewModel (private val getSupersUseCase: GetSupersUseCase) : ViewModel(){

    fun viewCreated(): List<Super> {
        return getSupersUseCase.invoke()
    }

}