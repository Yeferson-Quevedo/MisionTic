package com.example.latinshopapp.view.ui.activities.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.latinshopapp.R
import com.example.latinshopapp.view.ui.activities.model.productos
import com.example.latinshopapp.view.ui.activities.view.adapter.CarritoAdapter
import com.example.latinshopapp.view.ui.activities.view.adapter.onBookItemClickListener
import com.example.latinshopapp.view.ui.activities.viewmodel.TiendaViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase


class TiendaCompleta : Fragment(), onBookItemClickListener {

    lateinit var recyclerLib: RecyclerView
    lateinit var adapter: CarritoAdapter
    val database: FirebaseFirestore=FirebaseFirestore.getInstance()
    private val viewModel by lazy { ViewModelProvider(this).get(TiendaViewModel::class.java) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_tienda_completa,container,false)
        recyclerLib=view.findViewById(R.id.recyvlerview)
        adapter = CarritoAdapter(requireContext(),this)
        recyclerLib.layoutManager=LinearLayoutManager(context)
        recyclerLib.adapter=adapter
        observeData()

        return view
        //return inflater.inflate(R.layout.fragment_ellos2, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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


    fun observeData(){
        viewModel.libraryData().observe(viewLifecycleOwner, Observer {
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }

    override fun onItemClick(producto: productos, position: Int) {
        val titulo:String=producto.titulo
        val precio:String=producto.precio
        val image:String=producto.image
        val dato= hashMapOf(
            "titulo" to titulo,
            "precio" to precio,
            "image" to image
        )
        database.collection("compras")
            .document(titulo)
            .set(dato)
            .addOnSuccessListener {
                Toast.makeText(context, "Este producto fue añadido al carrito", Toast.LENGTH_SHORT).show()
            }
    }
}