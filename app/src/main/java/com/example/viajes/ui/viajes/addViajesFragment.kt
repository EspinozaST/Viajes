package com.example.viajes.ui.viajes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.viajes.R
import com.example.viajes.databinding.FragmentAddViajesBinding
import com.example.viajes.model.Viajes
import com.example.viajes.viewmodel.ViajesViewModel

class AddViajesFragment : Fragment() {
    private var _binding: FragmentAddViajesBinding? = null
    private val binding get() = _binding!!

     private lateinit var ViajesViewModel: ViajesViewModel
    override fun onCreateView(
             inflater: LayoutInflater, container: ViewGroup?,
            saveIntanceState: Bundle?
        ) :View {
            _binding =  FragmentAddViajesBinding.inflate(inflater, container, false)

        ViajesViewModel = ViewModelProvider(this).get(ViajesViewModel::class.java)

        binding.submitBtn.setOnClickListener { addViaje() }


            return binding.root
        }

    private fun addViaje(){
        val nombre= binding.viajesname.text.toString()

        if (validation(nombre)){
            //guardar el Viaje
            val viaje = Viajes(0,nombre)
            ViajesViewModel.addViajes(viaje)
            Toast.makeText(requireContext(),getString(R.string.msg_viaje_add), Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(requireContext(),getString(R.string.msg_error), Toast.LENGTH_LONG).show()
        }
    }

    private fun validation (nombre: String): Boolean{
        return !(nombre.isEmpty())
    }
}
