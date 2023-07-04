package com.gaur.composenewsapplication.domain.di

import com.gaur.composenewsapplication.data.network.ApiService
import com.gaur.composenewsapplication.data.network.AuthService
import com.gaur.composenewsapplication.data.repository.GetNewsArticleRepoImpl
import com.gaur.composenewsapplication.data.repository.LoginRepoImpl
import com.gaur.composenewsapplication.domain.repository.GetNewsArticleRepo
import com.gaur.composenewsapplication.domain.repository.LoginRepo
import com.gaur.composenewsapplication.domain.use_case.GetNewsArticleUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object LoginDomainModule {

    @Provides
    fun provideLoginRepo(authService: AuthService):LoginRepo{
        return LoginRepoImpl(authService = authService)
    }

}