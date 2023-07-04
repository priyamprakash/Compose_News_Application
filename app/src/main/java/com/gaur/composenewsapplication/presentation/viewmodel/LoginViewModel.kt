package com.gaur.composenewsapplication.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gaur.composenewsapplication.domain.use_case.GetNewsArticleUseCase
import com.gaur.composenewsapplication.domain.use_case.UserLoginUseCase
import com.gaur.composenewsapplication.presentation.HomeStateHolder
import com.gaur.composenewsapplication.presentation.LoginStateHolder
import com.gaur.composenewsapplication.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: UserLoginUseCase) :
    ViewModel() {

    val login = mutableStateOf(LoginStateHolder())


    fun loginUserFunction(){
        loginUseCase().onEach {
            when(it){
                is Resource.Loading->{
                    login.value = LoginStateHolder(isLoading = true)
                }
                is Resource.Success->{
                    login.value = LoginStateHolder(data = it.data)
                }
                is Resource.Error->{
                    login.value = LoginStateHolder(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }



}