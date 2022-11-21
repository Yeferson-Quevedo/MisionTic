package com.example.latinshopapp.view.ui.activities.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.latinshopapp.R
import com.example.latinshopapp.view.ui.activities.adapter.ComprasAdapter
import com.example.latinshopapp.view.ui.activities.adapter.onComprasItemClickListener
import com.example.latinshopapp.view.ui.activities.model.compras
import com.example.latinshopapp.view.ui.activities.viewmodel.ComprasViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase



class CarritoFragment : Fragment(), onComprasItemClickListener {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ComprasAdapter
    lateinit var precioS: TextView
    lateinit var precioIva: TextView
    lateinit var precioT: TextView
    lateinit var compraT:TextView
    val database:FirebaseFirestore=FirebaseFirestore.getInstance()
    private val viewmodel by lazy{ ViewModelProvider(this).get(ComprasViewModel::class.java)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         val view= inflater.inflate(R.layout.fragment_carrito, container, false)
        recyclerView=view.findViewById(R.id.recyvlerviewcarrito)
        precioS=view.findViewById(R.id.preciosubtotal)
        precioT=view.findViewById(R.id.preciototal)
        compraT=view.findViewById(R.id.realizarCompra)
        precioIva=view.findViewById(R.id.precio_iva)
        adapter= ComprasAdapter(requireContext(), this)
        recyclerView.layoutManager=LinearLayoutManager(context)
        recyclerView.adapter=adapter
        observeData()
        preciosubtotal()
        compraT.setOnClickListener{
            val builder=AlertDialog.Builder(requireContext())
            builder.setTitle("CompraLatinShop")
            builder.setMessage("¿Desea realizar esta compra?")
            builder.setPositiveButton("Aceptar"){
                    dialog,which->
                findNavController().navigate(R.id.action_carritoFragment_to_menuFragment)
            }
            builder.setNegativeButton("Rechazar", null)
            builder.show()
        }
        return view
    }

    private fun observeData() {
        viewmodel.fetchComprasData().observe(viewLifecycleOwner,Observer{
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }
    private fun preciosubtotal(){
        database.collection("compras")
            .get()
            .addOnSuccessListener {
                    result->
                val preciounitario= mutableListOf<String>()
                for(document in result){
                    val precio=document["precio"].toString()
                    preciounitario.add(precio!!)
                }
                val preciosubtotal=preciounitario.mapNotNull { it.toIntOrNull() }.sum()
                val precio_iva=preciosubtotal*0.19
                val precio_total=precio_iva+preciosubtotal


                val floatStr1 = precio_iva
                val floatVal1: String? = floatStr1.toString()

                val floatStr2=precio_total
                val strPrecio :String?=floatStr2.toString()

                precioIva.setText("$"+floatVal1)
                precioT.setText("$"+strPrecio)
                precioS.setText("$"+Integer.toString(preciosubtotal))

            }

        // private fun preciototal(subtotal:Double, iva:Double){
            //val subtotal= precioS.getInstance()(capturar el subtotal)
            //val iva= 0.19
            //val preciototal= subtotal+(subtotal*iva)
            //precioT.setText(Integer.toString(preciototal))}

        fun realizarCompra(){

        }

}
    override fun onItemClick(producto: compras, position: Int) {
        database.collection("compras")
            .document(producto.titulo)
            .delete()
    }

    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAuth= Firebase.auth
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


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

}
