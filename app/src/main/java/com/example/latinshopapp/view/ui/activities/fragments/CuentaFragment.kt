package com.example.latinshopapp.view.ui.activities.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.latinshopapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class CuentaFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button=view.findViewById<BottomNavigationView>(R.id.cuentaFragment)
        button.setOnNavigationItemReselectedListener(){
            when(it.itemId){R.id.home -> findNavController().navigate(R.id.cuentaFragment)

            }
        }
    }
}