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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

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


        //Navigation
        val btm= view.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        btm.setOnNavigationItemReselectedListener {
            when(it.itemId)
            {
                R.id.Nav_menu -> findNavController().navigate(R.id.menuFragment)
                R.id.Nav_profile ->findNavController().navigate(R.id.cuentaFragment)
                R.id.Nav_productos ->findNavController().navigate(R.id.catalogoFragment)
                R.id.Nav_cerrar ->{
                    firebaseAuth.signOut()
                    findNavController().navigate(R.id.loginActivity)
                    true
                }

            }
        }
    }

    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAuth= Firebase.auth
    }
}
