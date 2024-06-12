package com.reymon.myFirstApp.data.local.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.reymon.myFirstApp.data.local.database.dao.UsersDAO
import com.reymon.myFirstApp.data.local.database.entities.UsersDB

@Database(entities = [UsersDB::class], version = 1)
abstract class DataBaseRepository : RoomDatabase(){
    abstract fun usersDao(): UsersDAO


}