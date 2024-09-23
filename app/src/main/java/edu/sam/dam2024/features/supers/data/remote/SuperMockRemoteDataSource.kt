package edu.sam.dam2024.features.supers.data.remote

import edu.sam.dam2024.features.supers.domain.Super

// Esta clase es un mock de la fuente de datos remota
class SuperMockRemoteDataSource {
    fun getSupers(): List<Super> {
        return listOf(
            Super(
                "1",
                "THe Soap",
                "Invisibility",
                "Male, Caucasican, brown Hair, brown eyes, 180cm, 75 kg",
                "Born in 1990 in Madrid, México orfan since 17 years old",
                "Futbol Player",
                "ExMember of the atomicBoys",
                "image1"
            ),
            Super(
                "2",
                "Rick Grimes",
                "Control Fire",
                "Male, Caucasican, brown Hair, Blue eyes, 185cm, 84kg",
                "Born in 1985 in Los Angeles, California",
                " TV Series Actor",
                "Emp",
                "image2",

            ),
            Super(
                "3",
                "Experiment3",
                "Explosions",
                "Female or Male 175 cm, 65kg, Hair Yellow, red eyes",
                "NO DATA",
                "NO DATA",
                "NO DATA",
                "image3"
            ),
            Super(
                "4",
                "Fantastic5",
                "HyperElasticity",
                "Women Chinesse, 160cm, 50kg, brown hair brown eyes",
                "NO DATA",
                "Zoo Employer",
                "No DATA",
                "image4"
            )
        )
    }
}