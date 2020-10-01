package com.example.couplecalc.ViewModel

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.couplecalc.Model.LoginResponse
import com.example.couplecalc.Repository.UserRepository
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {

    var email :String? =null
    var password :String? =null

   lateinit var loginResponse:LiveData<LoginResponse>

    fun onLoginButtonClick(email:String,password:String) : LiveData<LoginResponse>
    {
        if(email.isNullOrEmpty()||password.isNullOrEmpty())
        {
            return loginResponse
        }
        else {
            loginResponse = repository.userLogin(email!!, password!!)
            return loginResponse
        }

    }

}