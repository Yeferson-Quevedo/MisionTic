package com.example.latinshopapp.view.ui.activities.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.latinshopapp.view.ui.activities.model.productos
import com.example.latinshopapp.view.ui.activities.repositorio.repo

class TiendaViewModel:ViewModel(){
    val repo=repo()
    fun libraryData():LiveData<MutableList<productos>>{
        val mutableData=MutableLiveData<MutableList<productos>>()
        repo.getLibraryData().observeForever { result ->
            mutableData.value=result
        }
        return mutableData
    }
}