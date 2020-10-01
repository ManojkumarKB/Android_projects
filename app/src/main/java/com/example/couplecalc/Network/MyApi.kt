package com.example.couplecalc.Network

import com.example.couplecalc.Model.LoginResponse
import com.example.couplecalc.Util.Constants
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import javax.inject.Inject
import javax.inject.Singleton


interface MyApi {

    @FormUrlEncoded
    @POST("login")
    fun userLgn(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>


}