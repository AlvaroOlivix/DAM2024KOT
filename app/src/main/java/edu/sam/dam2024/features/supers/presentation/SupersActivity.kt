package edu.sam.dam2024.features.supers.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.sam.dam2024.R
import edu.sam.dam2024.features.movies.presentation.MovieFactory
import edu.sam.dam2024.features.supers.data.local.SuperXmlLocalDataSource
import edu.sam.dam2024.features.supers.domain.Super

class SupersActivity : AppCompatActivity() {

    private lateinit var superFactory: SuperFactory
    private lateinit var viewModel: SupersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_supers)
        superFactory = SuperFactory(this)
        viewModel = superFactory.buildViewModel()

    }

    fun bindData(supers: List<Super>) {
        findViewById<TextView>(R.id.super_id_1).text = supers[0].id
        findViewById<TextView>(R.id.super_name_1).text = supers[0].name
        findViewById<TextView>(R.id.super_powerstats_1).text = supers[0].powerstats
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener {
            navigateToSuperDetail(supers[0].id)
        }

        findViewById<TextView>(R.id.super_id_2).text = supers[1].id
        findViewById<TextView>(R.id.super_name_2).text = supers[1].name
        findViewById<TextView>(R.id.super_powerstats_2).text = supers[1].powerstats

        findViewById<TextView>(R.id.super_id_3).text = supers[2].id
        findViewById<TextView>(R.id.super_name_3).text = supers[2].name
        findViewById<TextView>(R.id.super_powerstats_3).text = supers[2].powerstats

        findViewById<TextView>(R.id.super_id_4).text = supers[3].id
        findViewById<TextView>(R.id.super_name_4).text = supers[3].name
        findViewById<TextView>(R.id.super_powerstats_4).text = supers[3].powerstats

    }
    fun navigateToSuperDetail(superId: String) {
        startActivity(SuperDetailActivity.getIntent(this, superId))
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