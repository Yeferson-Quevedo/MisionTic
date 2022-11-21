package com.example.latinshopapp.view.ui.activities.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase


class CarritoFragment : Fragment(), onComprasItemClickListener {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ComprasAdapter
    lateinit var precioS: TextView
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
        adapter= ComprasAdapter(requireContext(), this)
        recyclerView.layoutManager=LinearLayoutManager(context)
        recyclerView.adapter=adapter
        observeData()
        preciosubtotal()
        compraT.setOnClickListener{
            realizarCompra()
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

                precioS.setText(Integer.toString(preciosubtotal))
            }

        // private fun preciototal(subtotal:Double, iva:Double){
            //val subtotal= precioS.getInstance()(capturar el subtotal)
            //val iva= 0.19
            //val preciototal= subtotal+(subtotal*iva)
            //precioT.setText(Integer.toString(preciototal))}

        private fun realizarCompra(){
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

    override fun onItemClick(producto: compras, position: Int) {
        database.collection("compras")
            .document(producto.titulo)
            .delete()
    }
}
}
