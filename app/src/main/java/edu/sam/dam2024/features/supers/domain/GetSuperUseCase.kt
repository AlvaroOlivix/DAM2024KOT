package edu.sam.dam2024.features.supers.domain


class GetSuperUseCase(private val superRepository: SuperRepository) {
    operator fun invoke(id: String): Super? {
        return superRepository.getSuper(id)
    }
}