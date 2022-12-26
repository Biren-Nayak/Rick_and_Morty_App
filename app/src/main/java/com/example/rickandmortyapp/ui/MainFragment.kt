package com.example.rickandmortyapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.adapters.CharactersAdapter
import com.example.rickandmortyapp.databinding.FragmentMainBinding
import com.example.rickandmortyapp.viewmodels.MainViewModel

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by activityViewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = FragmentMainBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.recyclerView.adapter = CharactersAdapter( CharactersAdapter.CharacterListener { character ->
            viewModel.onCharacterClicked(character)
            findNavController().navigate(R.id.action_mainFragment_to_characterDetailFragment)
        }).apply {
            binding.recyclerView.adapter = this
            viewModel.characters.observe(viewLifecycleOwner) {
                submitList(it)
            }
        }
    }

}