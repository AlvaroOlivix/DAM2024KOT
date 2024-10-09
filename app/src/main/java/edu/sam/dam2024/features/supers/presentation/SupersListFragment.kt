package edu.sam.dam2024.features.supers.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import edu.sam.dam2024.databinding.FragmentSupersBinding


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
        val observer = Observer<SupersListViewModel.UiState> {
            //Codigo que se ejecutará cunado desde el ViewModel hagamos un value o postValue
        }
        //Aqui no podremos hacer ni value ni postValue
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }
}