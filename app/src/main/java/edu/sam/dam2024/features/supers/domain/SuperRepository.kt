package edu.sam.dam2024.features.supers.domain

interface SuperRepository {
    suspend fun getSupers(): List<Super>
    fun getSuper(id:String): Super?
}