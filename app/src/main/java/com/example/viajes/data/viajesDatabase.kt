package com.example.viajes.data
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.viajes.model.Viajes


@Database(entities = [Viajes::class], version = 1, exportSchema = false)
abstract class ViajesDatabase: RoomDatabase(){
    abstract fun ViajesDao(): ViajesDao

    companion object{
        @Volatile
        private var INSTANCE: ViajesDatabase? = null

        fun getDatabase(context: android.content.Context): ViajesDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized( this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ViajesDatabase::class.java,
                    "Viajes_database"
                ).build()
                INSTANCE= instance
                return instance
            }
        }
    }

}
