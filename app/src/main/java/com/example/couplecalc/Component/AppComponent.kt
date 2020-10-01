package com.example.couplecalc.Component

import com.example.couplecalc.View.MainActivity
import com.example.couplecalc.di.Module.AppModule
import com.example.couplecalc.di.Module.AuthModule
import com.example.couplecalc.di.Module.LoginModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [LoginModule::class, AuthModule::class, AppModule::class])
@Singleton
interface AppCompon
{
    fun inject(activity: MainActivity)
}