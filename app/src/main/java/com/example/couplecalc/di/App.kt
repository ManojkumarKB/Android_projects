package com.example.couplecalc.di

import android.app.Application
import com.example.couplecalc.Component.AppCompon
import com.example.couplecalc.Component.DaggerAppCompon
import com.example.couplecalc.di.Module.AppModule
import com.example.couplecalc.di.Module.AuthModule

class App: Application(){


    companion object {
        lateinit var instance: App
        lateinit var appComponent: AppCompon

    }

    fun initializeDagger() {
        appComponent = DaggerAppCompon.builder() //The DaggerAppComponent will be generated when you build the project
            .appModule(AppModule(this))
            .authModule(AuthModule())
            .build()

    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        initializeDagger()
    }


}