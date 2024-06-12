package com.reymon.myFirstApp.ui.core

import android.app.Application
import androidx.room.Room
import com.reymon.myFirstApp.data.local.repository.DataBaseRepository
import java.sql.DriverManager.getConnection

class MyApplication : Application() {
    //Para que está aplicación inicie al arrancar el programa, hay que definirlo en el Manifest
    override fun onCreate() {
        super.onCreate()
        //Incializamos la conexión a la base de datos
        dbConnection =Room.databaseBuilder(
                applicationContext,
                DataBaseRepository::class.java,
                "UserData"
            ).build()
        }


    companion object {
        private var dbConnection: DataBaseRepository? = null
        fun getDbConnection(): DataBaseRepository {
            return dbConnection!!
        }
    }
}