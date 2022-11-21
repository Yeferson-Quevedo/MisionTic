package com.example.latinshopapp.view.ui.activities.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.latinshopapp.R
import androidx.recyclerview.widget.RecyclerView
//import com.google.firebase.database.core.Context
import android.content.Context
import com.example.latinshopapp.view.ui.activities.model.productos
import com.squareup.picasso.Picasso

class CarritoAdapter(private val context: Context, var clickListener: onBookItemClickListener): RecyclerView.Adapter<CarritoAdapter.ViewHolder>() {

    private var productoslista= mutableListOf<productos>()

    fun setListData(data:MutableList<productos>){
        productoslista=data
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i:Int):ViewHolder{
        val v=LayoutInflater.from(viewGroup.context).inflate(R.layout.card_view_shop,
            viewGroup,false)
        return ViewHolder(v)
    }
    inner class ViewHolder(itemview: View):RecyclerView.ViewHolder(itemview){
        fun binWew(producto:productos, action: onBookItemClickListener){
            itemView.findViewById<TextView>(R.id.titles).text=producto.titulo
            itemView.findViewById<TextView>(R.id.precio).text=producto.precio
            itemView.findViewById<TextView>(R.id.desc).text=producto.descripcion
            Picasso.with(context).load(producto.image).into(itemView.findViewById<ImageView>(R.id.image))
            val btncarrito=itemView.findViewById<ImageView>(R.id.carrito)
            btncarrito.setOnClickListener{
                action.onItemClick(producto, adapterPosition)
            }
        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i:Int) {
        val producto=productoslista[i]
        viewHolder.binWew(producto,clickListener)
    }

    override fun getItemCount(): Int {
        return if(productoslista.size>0){
            productoslista.size
        }else{
            0
        }
    }
}
interface onBookItemClickListener{
    fun onItemClick(producto: productos, position:Int)
}
