package com.example.latinshopapp.view.ui.activities.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.latinshopapp.R
import android.os.Bundle
import androidx.fragment.app.Fragment



class TiendaAdapter : RecyclerView.Adapter<TiendaAdapter.ViewHolder>(){

    override fun OnCreateViewHolder(viewGroup: ViewGroup, i:Int): ViewHolder{

        val v=LayoutInflater.from(viewGroup.context).inflate(R.layout.cad_view_tienda,
            viewGroup, false)

        return ViewHolder (v)
    }

    inner class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        var itemImage: ImageView
        var itemTitle : TextView
        var itemPrecio: TextView

        init{
            itemImage =ItemView.findViewById(R.id.card_image)
            itemTitle =ItemView.findViewById(R.id.card_tienda)
            itemPrecio =ItemView.findViewById(R.id.card_precio)

        }
    }

        val title=arrayOf("chaquetas","pantalon","buzo","ropa elegante","ropa oficina")
        val precio=arrayOf("$83.000","$53.000","$82.000","$32.000","42.000")
        val image= arrayOf(R.drawable.chaquetas,R.drawable.pantalon,R.drawable.buzopunto,R.drawable.ropaelegante,R.drawable.ropaoficina)


        override fun onBindViewHolder (viewHolder: ViewHolder, i: Int){
            viewHolder.itemTitle.text=title[i]
            viewHolder.itemPrecio.text=precio[i]
            viewHolder.itemImage.setImageResource(image[i])
        }

        override fun getItemCount(): Int {
            return title.size
        }
        

}

