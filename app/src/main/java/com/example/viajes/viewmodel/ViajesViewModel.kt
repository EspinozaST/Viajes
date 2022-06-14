package com.example.viajes.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.viajes.data.ViajesDao
import com.example.viajes.data.ViajesDatabase
import com.example.viajes.model.Viajes
import com.example.viajes.repository.ViajesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViajesViewModel(application: Application) : AndroidViewModel(application) {

    val getAllData: LiveData<List<Viajes>>

    private val repository: ViajesRepository

    init {
        val viajesDao = ViajesDatabase.getDatabase(application).ViajesDao()
        repository = ViajesRepository(viajesDao)
        getAllData = repository.getAllData
    }

    fun addViajes(viajes: Viajes){
     viewModelScope.launch(Dispatchers.IO) {repository.addViajes(viajes)}
    }
    fun updateViajes(viajes: Viajes){
        viewModelScope.launch(Dispatchers.IO) {repository.addViajes(viajes)}
    }
    fun deleteViajes(viajes: Viajes){
        viewModelScope.launch(Dispatchers.IO) {repository.addViajes(viajes)}
    }
















    private val _text = MutableLiveData<String>().apply {
        value = "This is Viajes Fragment"
    }
    val text: LiveData<String> = _text
}