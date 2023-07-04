package com.gaur.composenewsapplication.data.model.loginresponse

data class LoginResponse(
    val status: String,
    val token: String,
    val user: User
)