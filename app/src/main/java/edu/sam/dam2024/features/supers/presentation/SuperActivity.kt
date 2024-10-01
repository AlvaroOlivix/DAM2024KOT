package edu.sam.dam2024.features.supers.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.sam.dam2024.R
import edu.sam.dam2024.features.supers.data.local.SuperXmlLocalDataSource
import edu.sam.dam2024.features.supers.domain.Super

class SuperActivity : AppCompatActivity() {

    private val superFactory: SuperFactory = SuperFactory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //BuildViewModel es una función de SupersFactory
        val viewModel = superFactory.buildViewModel()

    }
/*
    fun bindData(supers:List<Super>) {
        findViewById<TextView>(R.id.super_id_1).text = supers[0].id
        findViewById<TextView>(R.id.super_name_1).text = supers[0].name
        findViewById<TextView>(R.id.super_powerstats_1).text = supers[0].powerstats

        findViewById<LinearLayout>(R.id.layout_2).setOnClickListener{
            val super1: Super? = viewModel.itemSelected(supers[0].id)
            super1?.let{
                Log.d("@dev", "Super Seleccionado: ${it.name}")
            }
        }
    }

 */
    private fun testxml(){
        val xmlDataSource = SuperXmlLocalDataSource(this)

    }
    override fun onStart() {
        super.onStart()
        Log.d("@dev", "onStart")
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }
}