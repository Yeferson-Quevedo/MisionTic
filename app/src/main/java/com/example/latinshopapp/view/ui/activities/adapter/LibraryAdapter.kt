package com.example.latinshopapp.view.ui.activities.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.latinshopapp.R
import androidx.recyclerview.widget.RecyclerView

class LibraryAdapter: RecyclerView.Adapter<LibraryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i:Int):ViewHolder{
        val v=LayoutInflater.from(viewGroup.context).inflate(R.layout.card_view_shop,
            viewGroup,false)
        return ViewHolder(v)
    }
    inner class ViewHolder(itemview: View):RecyclerView.ViewHolder(itemview){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemPrecio: TextView
        var itemDesc: TextView

        init {
            itemImage=itemview.findViewById(R.id.image)
            itemTitle=itemview.findViewById(R.id.titles)
            itemPrecio=itemview.findViewById(R.id.precio)
            itemDesc=itemview.findViewById(R.id.desc)
        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i:Int) {
        viewHolder.itemTitle.text=titles[i]
        viewHolder.itemPrecio.text=precio[i]
        viewHolder.itemDesc.text=desc[i]
        viewHolder.itemImage.setImageResource(image[i])
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    val titles= arrayOf("Buzo caballero","Jogger deportivo para caballero",
        "Traje elegante para caballero")
    val precio= arrayOf("$80.000", "$95.000", "$350.000")
    val desc= arrayOf("Buzo en algodon para caballero",
        "JPantalon deportivo para caballero estilo Jogger",
        "Traje elegante para caballero, incluye buzo negro cuello trotuga")
    val image= arrayOf(R.drawable.buzostilo, R.drawable.pantalon,
        R.drawable.buzostilo)

}
