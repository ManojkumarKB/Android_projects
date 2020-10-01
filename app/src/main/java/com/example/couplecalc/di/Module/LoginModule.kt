package com.example.couplecalc.di.Module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.couplecalc.di.Factory.DaggerViewModelFactory
import com.example.couplecalc.Util.Constants
import com.example.couplecalc.ViewModel.LoginViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import kotlin.reflect.KClass

@Module
abstract class LoginModule {

    @Binds
    abstract fun bindviewmodelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindmainViewModel1(viewmodel:LoginViewModel): ViewModel


}

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)