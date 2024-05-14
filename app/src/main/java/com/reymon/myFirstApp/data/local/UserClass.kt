package com.reymon.myFirstApp.data.local

import android.util.Log

data class UserClass(
    var id: Int =0,
    var name : String = "",
    var pass : String = ""
){
    init{
        Log.d("User Data Class", "User created!")
    }
}
