package com.gaur.composenewsapplication.presentation

import com.gaur.composenewsapplication.data.model.loginresponse.User
import com.gaur.composenewsapplication.domain.model.Article

data class LoginStateHolder(
    val isLoading:Boolean=false,
    val data:User?=null,
    val error:String=""

)
