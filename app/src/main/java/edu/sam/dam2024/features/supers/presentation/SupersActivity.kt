package edu.sam.dam2024.features.supers.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.sam.dam2024.R
import edu.sam.dam2024.features.supers.domain.Super

class SupersActivity : AppCompatActivity() {

    private lateinit var superFactory: SuperFactory
    private lateinit var viewModel: SuperListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super)



    }


}