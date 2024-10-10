package edu.sam.dam2024.features.supers.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import edu.sam.dam2024.databinding.FragmentSupersBinding
import edu.sam.dam2024.features.supers.domain.Super


class SupersListFragment : Fragment() {

    //Se ha añadido viewBinding en el gradel del proyecto
    private var _binding: FragmentSupersBinding? = null
    private val binding get() = _binding!!

    private lateinit var superFactory: SuperFactory
    private lateinit var viewModel: SupersListViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSupersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        superFactory = SuperFactory(requireContext())
        viewModel = superFactory.getSupersListViewModel()
        setUpObserver()
        viewModel.loadSupers()
    }

    private fun setUpObserver() {
        val observer = Observer<SupersListViewModel.UiState> { uiState ->
            uiState.supersList?.let { superList ->
                bindData(superList)
            }
            uiState.errorApp?.let {
                //Pinto el error
            } ?: run {
                //Ocultar el error
            }
            if (uiState.isLoading) {
                //Muestro cargando...
            } else {
                //Oculto cargando
            }
            //Codigo que se ejecutará cunado desde el ViewModel hagamos un value o postValue
        }
        //Aqui no podremos hacer ni value ni postValue
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    private fun bindData(supersList: List<Super>) {

        //Modo Kotlin
        binding.apply {
            super1.apply {
                text = supersList[0].name
                setOnClickListener {
                    //findNavController()

                }
            }
        }
        //Modo Tradicional(Java).
        binding.super2.text = supersList[1].name
        binding.super2.setOnClickListener {
        }
        binding.super3.text = supersList[2].name
        binding.super3.setOnClickListener {
        }

    }
}