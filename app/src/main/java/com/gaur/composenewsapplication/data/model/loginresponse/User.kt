package com.gaur.composenewsapplication.data.model.loginresponse

data class User(
    val address: String,
    val created_at: String,
    val email: String,
    val email_verified_at: Any,
    val id: Int,
    val image: String,
    val name: String,
    val otp: Any,
    val otp_expire_time: Any,
    val otp_verification_status: String,
    val password_update_at: String,
    val phone: String,
    val profession_id: String,
    val role_id: String,
    val type: String,
    val updated_at: String
)