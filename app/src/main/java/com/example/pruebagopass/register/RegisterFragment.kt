package com.example.pruebagopass.register

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.pruebagopass.databinding.FragmentRegisterBinding

class RegisterFragment: Fragment() {

    private val viewModel: RegisterViewModel by lazy {
        ViewModelProvider(this).get(RegisterViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRegisterBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel


        viewModel.user.observe(viewLifecycleOwner, Observer {
            if(it != null) {
                Log.d("Fuck this",  "$it")
                AlertDialog.Builder(activity)
                    .setTitle("Usuario registrado")
                    .setMessage("El usuario ${it.nombres} ha sido registrado con el uid ${it.uid}")
                    .setPositiveButton("Aceptar", DialogInterface.OnClickListener { dialogInterface, id ->
                        requireView().findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToEstablishmentsFragment())
                    })
                    .show()
            }
        })

        binding.saveButton.setOnClickListener {
            var error = false
            if(binding.nameInput.text.isNullOrEmpty()) {
                binding.nameInput.error = "Debes ingresar un nombre."
                error = true
            }
            if(binding.lastNameInput.text.isNullOrEmpty()) {
                binding.lastNameInput.error = "Debes ingresar un apellido."
                error = true
            }
            if(binding.emailAddressInput.text.isNullOrEmpty()) {
                binding.emailAddressInput.error = "Debes ingresar un correo."
                error = true
            }
            if(binding.phoneInput.text.isNullOrEmpty()) {
                binding.phoneInput.error = "Debes ingresar un teléfono."
                error = true
            }
            if(binding.idInput.text.isNullOrEmpty()) {
                binding.idInput.error = "Debes ingresar un documento valido."
                error = true
            }
            if(binding.passwordInput.text.isNullOrEmpty()) {
                binding.passwordInput.error = "Debes ingresar una contraseña."
                error = true
            }
            if(!error) viewModel.saveUser(binding.idTypeInput.text.toString(), binding.idInput.text.toString(), binding.nameInput.text.toString(), binding.lastNameInput.text.toString(), binding.phoneInput.text.toString(), binding.emailAddressInput.text.toString(), binding.passwordInput.text.toString())
        }

        return binding.root
    }
}