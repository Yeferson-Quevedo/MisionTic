package com.example.latinshopapp.view.ui.activities.fragments

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.latinshopapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class CuentaFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_cuenta, container, false)
        val view=inflater.inflate(R.layout.fragment_cuenta, container, false)
        val btmcamara=view.findViewById<Button>(R.id.btmcamara)
        btmcamara.setOnClickListener{
            val intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent,123)

        }

        val btmgaleria=view.findViewById<Button>(R.id.btmgaleria)
        btmgaleria.setOnClickListener{
            val intent=Intent(Intent.ACTION_PICK)
            intent.type="image/*"
            startActivityForResult(intent,456)

        }
        return view


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imageView=view?.findViewById<ImageView>(R.id.perfil)
        if (requestCode==123){
            var bitmap=data?.extras?.get("data") as Bitmap
            imageView?.setImageBitmap(bitmap)

        }else if(requestCode==456){
            imageView?.setImageURI(data?.data)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val btmcerrarSesion=view.findViewById<Button>(R.id.CerrarSesion)
        btmcerrarSesion.setOnClickListener(){
            firebaseAuth.signOut()
            findNavController().navigate(R.id.loginActivity)
            true
        }




        //editAccount

        val nombreCompleto=view.findViewById<EditText>(R.id.edtNombre)
        val correoCompleto=view.findViewById<EditText>(R.id.editTextEmail)
        val contrasena=view.findViewById<EditText>(R.id.editTextPassword)

        /*
        nombreCompleto.isEnabled=false
        correoCompleto.isEnabled=false
        contrasena.isEnabled=false
        */

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