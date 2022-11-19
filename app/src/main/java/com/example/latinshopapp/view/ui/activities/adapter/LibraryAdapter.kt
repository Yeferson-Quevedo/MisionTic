package com.example.latinshopapp.view.ui.activities.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView.OnChildClickListener
import android.widget.ImageView
import android.widget.TextView
import com.example.latinshopapp.R
import androidx.recyclerview.widget.RecyclerView
//import com.google.firebase.database.core.Context
import android.content.Context
import com.example.latinshopapp.view.ui.activities.model.productos
import com.squareup.picasso.Picasso


class LibraryAdapter(private val context: Context): RecyclerView.Adapter<LibraryAdapter.ViewHolder>() {

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
        fun binWew(producto:productos){
            itemView.findViewById<TextView>(R.id.titles).text=producto.titulo
            itemView.findViewById<TextView>(R.id.precio).text=producto.precio
            itemView.findViewById<TextView>(R.id.desc).text=producto.descripcion
            Picasso.with(context).load(producto.image).into(itemView.findViewById<ImageView>(R.id.image))
        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i:Int) {
        val producto=productoslista[i]
        viewHolder.binWew(producto)
    }

    override fun getItemCount(): Int {
        return if(productoslista.size>0){
            productoslista.size
        }else{
            0
        }
    }



}
