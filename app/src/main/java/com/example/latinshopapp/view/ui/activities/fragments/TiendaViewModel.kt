package com.example.latinshopapp.view.ui.activities.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.latinshopapp.view.ui.activities.repositorio.repo
class TiendaViewModel: ViewModel() {
    val repo = repo()
    fun tiendaData2():LiveData<MutableList<Tienda>>{
        val mutabledata= MutableLiveData<MutableList<Tienda>>()
        repo.getTiendaData().observeForever{result ->
            mutabledata.value= result
        }
        return mutabledata
    }
}