package edu.sam.dam2024.features.supers.data

import edu.sam.dam2024.features.supers.data.remote.SuperMockRemoteDataSource
import edu.sam.dam2024.features.supers.domain.Super
import edu.sam.dam2024.features.supers.domain.SuperRepository

//Esta recibe un argumento llamado remoteDataSource de tipo SuperMockRemoteDataSource
//y implementa la interfaz SuperRepository y define un método getSupers() que devuelve una lista de Super

class SuperDataRepository(private val remoteDataSource: SuperMockRemoteDataSource) :
    SuperRepository {
    //Devuelve la lista de supers
    override fun getSupers(): List<Super> {
        return remoteDataSource.getSupers()
    }

    override fun getSuper(id: String): Super? {
        return remoteDataSource.getSuper(id)
    }

}