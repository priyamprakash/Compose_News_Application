package com.gaur.composenewsapplication.data.repository

import android.util.Log
import com.gaur.composenewsapplication.data.model.loginresponse.LoginResponse
import com.gaur.composenewsapplication.data.model.loginresponse.User
import com.gaur.composenewsapplication.data.network.ApiService
import com.gaur.composenewsapplication.data.network.AuthService
import com.gaur.composenewsapplication.domain.model.Article
import com.gaur.composenewsapplication.domain.repository.GetNewsArticleRepo
import com.gaur.composenewsapplication.domain.repository.LoginRepo
import com.gaur.composenewsapplication.mappers.toDomain
import com.gaur.composenewsapplication.utils.SafeApiRequest
import javax.inject.Inject

class LoginRepoImpl @Inject constructor(private val authService: AuthService) :
    LoginRepo , SafeApiRequest(){


    override suspend fun loginUser(): User {
        val response = safeApiRequest { authService.userLogin() }
        Log.d("H_TAG", "loginUser: ${response.user}")
        return response.user
    }

}