package com.example.viajes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class viajesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Viajes Fragment"
    }
    val text: LiveData<String> = _text
}