package com.example.latinshopapp.view.ui.activities.repositorio
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.latinshopapp.view.ui.activities.model.productos
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class repo {
    fun getLibraryData():LiveData<MutableList<productos>>{
        val mutableData=MutableLiveData<MutableList<productos>>()
        FirebaseFirestore.getInstance().collection("productos").get()
            .addOnSuccessListener {result ->
                val listData= mutableListOf<productos>()
                for(document in result){
                    val titulo=document.getString("titulo")
                    val precio=document.getString("precio")
                    val descripcion=document.getString("descripcion")
                    val image=document.getString("image")
                    val producto=productos(titulo!!,precio!!,descripcion!!,image!!)
                    listData.add(producto)
                }
                mutableData.value=listData
        }
        return mutableData
    }

}

