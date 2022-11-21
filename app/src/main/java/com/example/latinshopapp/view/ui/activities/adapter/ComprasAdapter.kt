package com.example.latinshopapp.view.ui.activities.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.latinshopapp.R
import androidx.recyclerview.widget.RecyclerView
//import com.google.firebase.database.core.Context
import android.content.Context
import com.example.latinshopapp.view.ui.activities.model.compras
import com.example.latinshopapp.view.ui.activities.model.productos
import com.squareup.picasso.Picasso

class ComprasAdapter(private val context: Context, var clickListener: onComprasItemClickListener): RecyclerView.Adapter<ComprasAdapter.ViewHolder>() {

    private var productoslista= mutableListOf<compras>()

    fun setListData(data:MutableList<compras>){
        productoslista=data
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i:Int):ViewHolder{
        val v=LayoutInflater.from(viewGroup.context).inflate(R.layout.card_view_compras,
            viewGroup,false)
        return ViewHolder(v)
    }
    inner class ViewHolder(itemview: View):RecyclerView.ViewHolder(itemview){
        fun binWew(producto:compras, action: onComprasItemClickListener){
            itemView.findViewById<TextView>(R.id.titles).text=producto.titulo
            itemView.findViewById<TextView>(R.id.precio).text=producto.precio
            //itemView.findViewById<TextView>(R.id.desc).text=producto.descripcion
            Picasso.with(context).load(producto.image).into(itemView.findViewById<ImageView>(R.id.image))
            val btndelete=itemView.findViewById<ImageView>(R.id.delete)
            btndelete.setOnClickListener{
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
interface onComprasItemClickListener{
    fun onItemClick(producto: compras, position:Int)
}
