package com.example.pruebagopass.establishments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pruebagopass.databinding.FragmentEstablishmentBinding

class EstablishmentsFragment: Fragment() {

    private val viewModel: EstablishmentViewModel by lazy {
        ViewModelProvider(this).get(EstablishmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentEstablishmentBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        return binding.root
    }
}