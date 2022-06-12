package com.example.viajes.model
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import androidx.room.Entity
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName= "viajes")
data class Viajes (
    @PrimaryKey(autoGenerate= true)
    val id: Int,
    @ColumnInfo(name= "nombre")
    val nombre: String = ""

): Parcelable