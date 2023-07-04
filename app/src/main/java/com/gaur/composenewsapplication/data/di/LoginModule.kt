package com.gaur.composenewsapplication.data.di

import com.gaur.composenewsapplication.data.network.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object LoginModule {


    @Provides
    fun provideAuthService(): AuthService {
        return Retrofit.Builder().baseUrl("https://securityoncalls.com/projects/Atease/api/").addConverterFactory(GsonConverterFactory.create())
            .build().create(AuthService::class.java)
    }

}


