package com.example.latinshopapp.view.ui.activities.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.latinshopapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class CatalogoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_catalogo, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cardcatalogue=view.findViewById<ImageView>(R.id.imageEllos)
        cardcatalogue.setOnClickListener(){
            findNavController().navigate(R.id.action_catalogoFragment_to_tiendaCompleta)
        }


    }
}
