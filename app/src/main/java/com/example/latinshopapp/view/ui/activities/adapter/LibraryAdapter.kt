package com.example.latinshopapp.view.ui.activities.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.latinshopapp.R
import androidx.recyclerview.widget.RecyclerView
import com.example.latinshopapp.view.ui.activities.fragments.Tienda
import com.squareup.picasso.Picasso

class LibraryAdapter(private val context: Context): RecyclerView.Adapter<LibraryAdapter.ViewHolder>() {
    private var tiendalista= mutableListOf<Tienda>()

    fun setListData(data: MutableList<Tienda>){
        tiendalista = data
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, i:Int):ViewHolder{
        val v=LayoutInflater.from(viewGroup.context).inflate(R.layout.card_view_shop,
            viewGroup,false)
        return ViewHolder(v)
    }
    inner class ViewHolder(itemview: View):RecyclerView.ViewHolder(itemview){
      fun binwew(tienda: Tienda){
          itemView.findViewById<TextView>(R.id.titles).text= tienda.titulo
          itemView.findViewById<TextView>(R.id.precio).text= tienda.precio
          itemView.findViewById<TextView>(R.id.desc).text= tienda.descripcion
          Picasso.with(context).load(tienda.image).into(itemView.findViewById<ImageView>(R.id.image))
      }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i:Int) {
        val tienda= tiendalista[i]
        viewHolder.binwew(tienda)
    }

    override fun getItemCount(): Int {
        return if(tiendalista.size > 0){
            tiendalista.size
        }else{
            0
        }
    }

    val titles= arrayOf(
        "Chaqueta de cuero",
        "Jogger deportivo para caballero",
        "Buzo de hilo",
        "Camisa elegante para caballero",
        "Traje elegante para caballero",
        "Buzo NASA para caballero",
        "Buzo blanco para caballero",
        "Buzo elegante para caballero")
    val precio= arrayOf(
        "$200.000",
        "$70.000",
        "$75.000",
        "$80.000",
        "$380.000",
        "$80.000",
        "$80.000",
        "$120.000")
    val desc= arrayOf(
        "Chaqueta 100% cuero de excelente calidad, con costura italiana.",
        "Pantalon deportivo para caballero estilo Jogger.",
        "Buzo en hilo rojo para caballero.",
        "Camisa blanca elegante para caballero.",
        "Traje gris para caballero formal, incluye buso cuello tortuga negro de algodón.",
        "Buzo para caballero 100% algodón de la NASA.",
        "Buzo para caballero 100% algodón.",
        "Buzo para caballero negro 100% algodón.")
    val image= arrayOf(
        R.drawable.chaquetas,
        R.drawable.pantalon,
        R.drawable.buzopunto,
        R.drawable.ropaelegante,
        R.drawable.ropaoficina,
        R.drawable.buzonasa,
        R.drawable.buzonino,
        R.drawable.buzostilo,)

}
