package edu.sam.dam2024.features.supers.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class SuperActivity : AppCompatActivity() {

    private val superFactory: SuperFactory = SuperFactory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //BuildViewModel es una función de SupersFactory
        val viewModel = superFactory.buildViewModel()

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