package com.example.testapplication.data

import java.io.Serializable

data class LoginRequest(var email:String, var password: String): Serializable
