package com.example.couplecalc.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.couplecalc.Component.DaggerAppCompon
import com.example.couplecalc.R
import com.example.couplecalc.ViewModel.LoginViewModel
import com.example.couplecalc.di.App
import kotlinx.android.synthetic.main.login_layout.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    lateinit var myViewModel:LoginViewModel

   // private fun initializeDagger() = App.appComponent.inject(this)
   lateinit var t:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_layout)
       //initializeDagger()
        DaggerAppCompon.create().inject(this)
        loginBtn.setOnClickListener{

            myViewModel = ViewModelProviders.of(this,factory).get(LoginViewModel::class.java)

     //       myViewModel.onLoginButtonClick(edtxUserName.text.toString(),edtxPassword.text.toString())

            t="56"
            if(TextUtils.isEmpty(edtxPassword.text.toString())||edtxUserName.text.equals(""))
            {
                txtLoginResult.text="Enter the Email and password"
            }

            else {
                var loginrp = myViewModel.onLoginButtonClick( edtxUserName.text.toString(), edtxPassword.text.toString())
              //  Log.d("LoginActivityRespons",loginrp.value?.user.toString())

                loginrp.observe(this, Observer { response ->
                    t="-1"
                    Log.d("LogResponse",loginrp.value?.message)
                 if(loginrp.value?.user==null) {
                      txtLoginResult.text = "InvaValid Credentials"
                      Toast.makeText(this, "Invalid User name and password", Toast.LENGTH_LONG)
                          .show()
                     t="2"
                  }
                    else
                      {
                        Toast.makeText(this, loginrp.value?.user.toString(), Toast.LENGTH_LONG)
                            .show()
                        txtLoginResult.text="Valid Credentials"
                        t="1"
                   }
                    if(t.equals("1")&&loginrp.value!=null)
                        Log.d("loginresp",loginrp.value?.message)
                    if(t.equals("2"))
                    {
                        Log.d("jbjb","null")
                    }
                    if(t.equals("1"))
                    {
                        Log.d("bjbjbub","not null")
                    }

                })

                if(((t!="1")&&(t!="-1"))&&(t.equals("56")))
                     txtLoginResult.text="InvalidCredentials"

                t="56"
            /*    if(t==0)
                {
                    Toast.makeText(this,"Invalid login",Toast.LENGTH_LONG).show()
                }*/
            }
            /* else
             {
                 Toast.makeText(this,"Invalid user",Toast.LENGTH_LONG)
                 txtLoginResult.text="Invalid Credentials"
             }*/
        }

    }
}