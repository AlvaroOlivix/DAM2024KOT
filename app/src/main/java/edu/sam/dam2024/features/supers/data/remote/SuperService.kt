package edu.sam.dam2024.features.supers.data.remote

import edu.sam.dam2024.features.supers.domain.Super
import retrofit2.Response
import retrofit2.http.GET

interface SuperService {

    /* REST API:
    POST : Crear un recurso
    GET : Obtener información
    PUT : Actualizar información
    POST : Enviar información
    DELETE : Eliminar información
     */
    @GET("all.json")
    /*
    Response en vez de call es porque usaremos corrutinas,
    Si usamos corrutinas es necesario usar suspend para que solo sean llamadas dentro de una corrutina
    */
    suspend fun requestSupers(): Response<List<Super>>
    //suspend fun requestSupers(): Call<List<Super>>


}