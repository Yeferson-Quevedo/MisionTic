package com.example.latinshopapp.view.ui.activities.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.latinshopapp.R


class MenuFragment : Fragment() {

    @SuppressLint("MissingInflateId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_menu,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cardcatalogue=view.findViewById<ImageView>(R.id.cardcatalogo)
        cardcatalogue.setOnClickListener(){
            findNavController().navigate(R.id.action_menuFragment_to_catalogoFragment)
        }
        val cardcar=view.findViewById<ImageView>(R.id.cardcarrito)
        cardcar.setOnClickListener(){
            findNavController().navigate(R.id.action_menuFragment_to_carritoFragment)
        }

        val cardprofile=view.findViewById<ImageView>(R.id.cardcuenta)
        cardprofile.setOnClickListener(){
            findNavController().navigate(R.id.action_menuFragment_to_cuentaFragment)
        }

        val cardlist=view.findViewById<ImageView>(R.id.cardwishlist)
        cardlist.setOnClickListener(){
            findNavController().navigate(R.id.action_menuFragment_to_wishlistFragment)
        }

        val cardroute=view.findViewById<ImageView>(R.id.cardruta)
        cardroute.setOnClickListener(){
            findNavController().navigate(R.id.action_menuFragment_to_rutapedidoFragment)
        }

        val cardhelp=view.findViewById<ImageView>(R.id.cardayuda)
        cardhelp.setOnClickListener(){
            findNavController().navigate(R.id.action_menuFragment_to_ayudaFragment)
        }
    }
}