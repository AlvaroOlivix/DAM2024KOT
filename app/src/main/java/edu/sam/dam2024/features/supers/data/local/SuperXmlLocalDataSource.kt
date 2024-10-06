package edu.sam.dam2024.features.supers.data.local

import android.content.Context
import com.google.gson.Gson
import edu.sam.dam2024.R
import edu.sam.dam2024.features.supers.domain.Super

//Naming Modelo +Tecnología (Fichero XML) + LocalDataSource
class SuperXmlLocalDataSource(private val context: Context) {
    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.name_file2_xml), Context.MODE_PRIVATE
    )
    private val gson = Gson()

    fun save(sup: Super) {
        val editor = sharedPref.edit()
        editor.putString(sup.id, gson.toJson(sup))
        editor.apply()
    }

    fun saveAll(supers: List<Super>) {
        val editor = sharedPref.edit()
        supers.forEach { sup ->
            editor.putString(sup.id, gson.toJson(sup))
        }
        editor.apply()
    }

    fun findAll(): List<Super> {
        val supers = ArrayList<Super>()

        val mapSupers = sharedPref.all
        mapSupers.values.forEach { jsonSup ->
            val sup = gson.fromJson(jsonSup as String, Super::class.java)
            supers.add(sup)
        }
        return supers
    }

    fun findById(supId: String): Super? {
        return sharedPref.getString(supId, null)?.let { jsonSup ->
            gson.fromJson(jsonSup, Super::class.java)
        }
    }

    fun delete() {
        sharedPref.edit().clear().apply()
    }

    fun deleteById(supId: String) {
        sharedPref.edit().remove(supId).apply()
    }
}
