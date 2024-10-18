package edu.sam.dam2024.features.supers.data

import edu.sam.dam2024.features.supers.data.local.SuperXmlLocalDataSource
import edu.sam.dam2024.features.supers.data.remote.SuperApiRemoteDataSource
import edu.sam.dam2024.features.supers.data.remote.SuperMockRemoteDataSource
import edu.sam.dam2024.features.supers.domain.Super
import edu.sam.dam2024.features.supers.domain.SuperRepository

//Esta recibe un argumento llamado remoteDataSource de tipo SuperMockRemoteDataSource
//y implementa la interfaz SuperRepository y define un método getSupers() que devuelve una lista de Super

class SuperDataRepository(
    private val superApiRemoteDataSource: SuperApiRemoteDataSource,
) : SuperRepository {

    override suspend fun getSupers(): List<Super> {
        return superApiRemoteDataSource.getSupers()
    }

    override fun getSuper(id: String): Super? {
        TODO("Not yet implemented")
    }


    /*
        override fun getSupers(): List<Super> {
            val supersFromLocal = localData.findAll()
            if (supersFromLocal.isEmpty()) {
                val supersFromRemote = remoteDataSource.getSupers()
                localData.saveAll(supersFromRemote)
                return supersFromRemote
            } else {
                return supersFromLocal
            }
        }

        override fun getSuper(id: String): Super? {
            val superLocal = localData.findById(id)
            if (superLocal == null) {
                remoteDataSource.getSuper(id)?.let {
                    localData.save(it)
                    return it
                }
            }
            return superLocal
        }

     */

}