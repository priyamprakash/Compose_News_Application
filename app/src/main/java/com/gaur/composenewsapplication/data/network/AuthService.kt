package com.gaur.composenewsapplication.data.network

import com.gaur.composenewsapplication.data.model.NewsDTO
import com.gaur.composenewsapplication.data.model.loginresponse.LoginResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthService {

    // https://newsapi.org/v2/top-headlines?country=us&apiKey=436a7b507ee5433bafa1ad67c8eff93b

    @POST("login")
    suspend fun userLogin(
        @Query("email_or_phone") email:String= "totikip767@camplvad.com",
        @Query("password") password:String="12345678"
    ):Response<LoginResponse>



}