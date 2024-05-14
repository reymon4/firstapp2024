package com.reymon.myFirstApp.logic.usercases

import com.reymon.myFirstApp.data.local.UserClass
import com.reymon.myFirstApp.data.local.repository.ListUsers

class LoginUsercase(val listUser: ListUsers) {
    operator fun invoke(user: String, password: String): Result<UserClass> {
        var us = listUser.checkUserPassword(user, password)

        return if (us!= null){
            Result.success(us)
        } else {
            Result.failure(Exception("Check your username or password!"))
        }
    }

}
