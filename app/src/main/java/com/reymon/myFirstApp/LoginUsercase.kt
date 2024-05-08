package com.reymon.myFirstApp

class LoginUsercase {
    operator fun invoke (user: String, password: String): Result<Int> {
        return if (user == "admin" && password == "admin") {
            Result.success(45)
        } else {
            Result.failure(Exception("Check your username or password!"))
        }
    }
}
