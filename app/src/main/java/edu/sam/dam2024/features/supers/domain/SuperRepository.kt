package edu.sam.dam2024.features.supers.domain

interface SuperRepository {
    fun getSupers(): List<Super>
}