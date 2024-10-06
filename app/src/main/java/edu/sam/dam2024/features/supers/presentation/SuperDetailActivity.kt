package edu.sam.dam2024.features.supers.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import edu.sam.dam2024.R
import edu.sam.dam2024.features.supers.domain.Super

class SuperDetailActivity : AppCompatActivity() {
    private lateinit var superFactory: SuperFactory
    private lateinit var viewModel: SuperDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_detail)
        superFactory = SuperFactory(this)
        viewModel = superFactory.buildSuperDetailViewModel()

        getSuperId()?.let { superId ->
            viewModel.viewCreated(superId)?.let {
                sup ->
                bindData(sup)
            }
        }

    }

    private fun getSuperId(): String? {
        return intent.getStringExtra(KEY_SUPER_ID)
    }

    fun bindData(sup: Super) {

    }

    companion object {
        val KEY_SUPER_ID = "key_super_id"

        fun getIntent(context: Context, superId: String): Intent {
            val intent = Intent(context, SuperDetailActivity::class.java)
            intent.putExtra(KEY_SUPER_ID, superId)
            return intent
        }
    }
}