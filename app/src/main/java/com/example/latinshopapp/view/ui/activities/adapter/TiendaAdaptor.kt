package com.example.latinshopapp.view.ui.activities.view.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.latinshopapp.R
import androidx.recyclerview.widget.RecyclerView

class TiendaAdaptor: RecyclerView.Adapter<TiendaAdaptor.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i:Int):ViewHolder{
        val v=LayoutInflater.from(viewGroup.context).inflate(R.layout.cad_view_tienda,
            viewGroup,false)
        return ViewHolder(v)
}
    inner class ViewHolder(Itemview: View):RecyclerView.ViewHolder(Itemview){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemPrecio: TextView
        var itemDesc: TextView

        init {
            itemImage=Itemview.findViewById(R.id.card_image)
            itemTitle=Itemview.findViewById(R.id.titulo_tienda)
            itemPrecio=Itemview.findViewById(R.id.card_precio)
            itemDesc=Itemview.findViewById(R.id.card_descripcion)
        }
    }

    val titles= arrayOf("Buzo caballero","Jogger deportivo para caballero", "Traje elegante para caballero","Buzo deportivo", "Chaqueta de cuero", "Ropa para oficina")
    val precio= arrayOf("$80.000", "$95.000", "$70.000","$95.000","$380.000",)
    val desc= arrayOf("Buzo en algodon para caballero", "JPantalon deportivo para caballero estilo Jogger", "Traje elegante para caballero, incluye buzo negro cuello trotuga",
        "Buzo deportivo a la moda para caballero en varios colores", "Chaqueta de cuero, sofisticada y elegante","Ropa para oficina sin dejar de lado un buen estilo")
    val image= arrayOf(R.drawable.buzopunto,R.drawable.pantalon,R.drawable.ropaoficina,R.drawable.buzostilo,R.drawable.chaquetas,R.drawable.ropaelegante)


    override fun onBindViewHolder(viewHolder: ViewHolder, i:Int) {
        viewHolder.itemTitle.text=titles[i]
        viewHolder.itemPrecio.text=precio[i]
        viewHolder.itemDesc.text=desc[i]
        viewHolder.itemImage.setImageResource(image[i])
    }

    override fun getItemCount(): Int {
        return titles.size
    }

}
