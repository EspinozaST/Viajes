package com.example.viajes.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.viajes.model.Viajes


@Dao
interface ViajesDao {

    @Query( "SELECT * FROM VIAJES")
    fun getAlData(): LiveData<List<Viajes>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addViajes(viajes: Viajes)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateViajes(viajes: Viajes)

    @Delete
    suspend fun deleteViajes(viajes: Viajes)
}