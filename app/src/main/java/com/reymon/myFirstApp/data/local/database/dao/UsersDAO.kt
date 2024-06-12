package com.reymon.myFirstApp.data.local.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.reymon.myFirstApp.data.local.database.entities.UsersDB

@Dao
interface UsersDAO {
    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<UsersDB>

    @Query("SELECT * FROM users WHERE id_user = :id")
    fun getUserById(id: Int): UsersDB

    @Insert
    suspend fun insertUser(user: List<UsersDB>)

    @Delete
    suspend fun deleteUser(user: UsersDB)

}