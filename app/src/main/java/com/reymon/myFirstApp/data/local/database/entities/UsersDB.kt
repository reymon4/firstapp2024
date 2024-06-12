package com.reymon.myFirstApp.data.local.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UsersDB(
    @PrimaryKey(autoGenerate = true)
    //Optional info
    @ColumnInfo(name = "id_user")
    val id: Int=0,
    @ColumnInfo(name = "name_user")
    val name: String?,
    @ColumnInfo(name = "email_user")
    val email: String?,
    @ColumnInfo(name = "password_user")
    val password: String?
)
