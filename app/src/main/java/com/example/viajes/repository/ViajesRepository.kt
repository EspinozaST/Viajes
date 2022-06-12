package com.example.viajes.repository

import android.telephony.VisualVoicemailService
import androidx.lifecycle.LiveData
import com.example.viajes.data.ViajesDao
import com.example.viajes.model.Viajes
import java.security.cert.CertPathValidatorSpi

class ViajesRepository(private val ViajesDao: ViajesDao) {
    val getAllData: LiveData<List<Viajes>> = ViajesDao.getAlData()

    suspend fun addViajes(viajes: Viajes){
        ViajesDao.addViajes(viajes)
    }
    suspend fun updateViajes(viajes: Viajes){
        ViajesDao.updateViajes(viajes)
    }
    suspend fun deleteViajes(viajes: Viajes){
        ViajesDao.deleteViajes(viajes)
    }
}