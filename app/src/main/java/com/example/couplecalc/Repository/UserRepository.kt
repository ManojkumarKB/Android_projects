package com.example.couplecalc.Repository


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.couplecalc.Component.DaggerAppCompon
import com.example.couplecalc.Model.LoginResponse

import com.example.couplecalc.Network.MyApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import javax.inject.Inject

class UserRepository @Inject constructor()  {

    @Inject
    lateinit var MyApi :MyApi

    fun userLogin(email: String, password: String): LiveData<LoginResponse> {



        val loginResponse = MutableLiveData<LoginResponse>()


        MyApi.userLgn(email,password).enqueue(object :Callback<LoginResponse>{
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
               Log.d("User Repository","onFailure")
            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if(response.isSuccessful)
                {
                    loginResponse.value = response.body()
                }
            }
        })



        return loginResponse
    }


}

interface api
{
    @FormUrlEncoded
    @POST("login")
    fun userLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<ResponseBody>
}