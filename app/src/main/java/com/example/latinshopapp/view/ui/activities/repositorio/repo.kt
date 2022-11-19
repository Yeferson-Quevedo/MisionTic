package com.example.latinshopapp.view.ui.activities.repositorio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.latinshopapp.view.ui.activities.fragments.Tienda
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class repo {
    fun getTiendaData():LiveData<MutableList<Tienda>>{
        val mutabledata= MutableLiveData<MutableList<Tienda>>()

        FirebaseFirestore.getInstance().collection("tienda").get()
            .addOnSuccessListener{ result->
               val listData = mutableListOf<Tienda>()
                for (document in result){
                val titulo = document.getString("titulo")  //get del crue
                    val precio = document.getString("precio")
                    val descripcion = document.getString("descripcion")
                    val image = document.getString("image")
                    val tienda= Tienda(titulo!!,precio!!,descripcion!!, image!!)
                    listData.add(tienda)
                }
                mutabledata.value = listData
            }
        return mutabledata //consulta la base de datos
}}