package com.example.couplecalc.Model

data class LoginResponse(var isSuccessful: Boolean, var message: String, var user: UserResponse)
data class UserResponse(var id: Int, var name: String, var email: String)