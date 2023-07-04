package com.gaur.composenewsapplication.domain.repository

import com.gaur.composenewsapplication.data.model.loginresponse.LoginResponse
import com.gaur.composenewsapplication.data.model.loginresponse.User

interface LoginRepo {

    suspend fun loginUser(): User

}