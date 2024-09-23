package edu.sam.dam2024.features.supers.domain

class GetSuperUseCase (private val superRepository: SuperRepository){


    //Es igual a execute
    operator fun invoke(): List<Super> {
        return superRepository.getSupers()
    }

}