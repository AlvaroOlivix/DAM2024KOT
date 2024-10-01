package edu.sam.dam2024.features.supers.data.local

import android.content.Context
import edu.sam.dam2024.R
import edu.sam.dam2024.features.supers.domain.Super

//Naming Modelo +Tecnología (Fichero XML) + LocalDataSource
class SuperXmlLocalDataSource(private val context: Context) {
    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.name_file2_xml), Context.MODE_PRIVATE
    )

    fun findSuper(): Super {
        sharedPref.apply {
            return Super(
                getString("id", " ")!!,
                getString("name", " ")!!,
                getString("powerstats", " ")!!,
                getString("appeareance", " ")!!,
                getString("biography", " ")!!,
                getString("work", " ")!!,
                getString("connections", " ")!!,
                getString("image", " ")!!
            )
        }
    }


}
