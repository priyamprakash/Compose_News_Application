package com.gaur.composenewsapplication.domain.use_case

import com.gaur.composenewsapplication.data.model.loginresponse.LoginResponse
import com.gaur.composenewsapplication.data.model.loginresponse.User
import com.gaur.composenewsapplication.domain.model.Article
import com.gaur.composenewsapplication.domain.repository.GetNewsArticleRepo
import com.gaur.composenewsapplication.domain.repository.LoginRepo
import com.gaur.composenewsapplication.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserLoginUseCase @Inject constructor(private val loginRepo: LoginRepo) {

    operator fun invoke(): Flow<Resource<User>> = flow {
        emit(Resource.Loading(""))
         try{
             emit(Resource.Success(loginRepo.loginUser()))
         }catch (e:Exception){
            emit(Resource.Error(e.message))
        }

    }

}