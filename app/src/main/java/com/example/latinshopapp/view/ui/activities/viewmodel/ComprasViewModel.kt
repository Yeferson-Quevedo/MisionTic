package com.example.latinshopapp.view.ui.activities.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.latinshopapp.view.ui.activities.model.compras
import com.example.latinshopapp.view.ui.activities.repositorio.repo

class ComprasViewModel: ViewModel() {
    val repo=repo()
    fun fetchComprasData():LiveData<MutableList<compras>>{
        val mutableData=MutableLiveData<MutableList<compras>>()
        repo.getComprasData().observeForever(){
            mutableData.value=it
        }
        return mutableData
    }
}