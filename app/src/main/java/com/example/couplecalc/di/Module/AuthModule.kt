package com.example.couplecalc.di.Module

import com.example.couplecalc.Network.MyApi
import com.example.couplecalc.Util.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AuthModule {
    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit
    {
        return Retrofit.Builder()
            .baseUrl(Constants.getBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideLoginApi(retrofit: Retrofit) =
        retrofit.create(MyApi::class.java)
}