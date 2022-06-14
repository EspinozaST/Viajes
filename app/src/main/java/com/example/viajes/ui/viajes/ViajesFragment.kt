package com.example.viajes.ui.viajes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.viajes.R
import com.example.viajes.databinding.FragmentViajesBinding
import com.example.viajes.viewmodel.ViajesViewModel


class ViajesFragment : Fragment() {
    private lateinit var ViajesViewModel: ViajesViewModel
    private var _binding: FragmentViajesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        ViajesViewModel = ViewModelProvider(this).get(ViajesViewModel::class.java)
        _binding = FragmentViajesBinding.inflate(inflater, container, false)

        binding.addViajeBtn.setOnClickListener{
            findNavController().navigate(R.id.action_nav_viajes_to_addViajesFragment)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}