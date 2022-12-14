package com.example.latinshopapp.view.ui.activities.fragments

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.core.graphics.drawable.IconCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentContainer

import androidx.navigation.fragment.findNavController
import com.example.latinshopapp.R
//import com.example.latinshopapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

import com.google.android.material.navigation.NavigationView.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MenuFragment : Fragment(){



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



        val cardroute=view.findViewById<ImageView>(R.id.cardruta)
        cardroute.setOnClickListener(){
            findNavController().navigate(R.id.action_menuFragment_to_rutapedidoFragment)
        }


        //navigation

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
        firebaseAuth=Firebase.auth
    }


}