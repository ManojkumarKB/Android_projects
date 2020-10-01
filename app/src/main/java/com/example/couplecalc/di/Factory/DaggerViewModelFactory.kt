package com.example.couplecalc.di.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider

class DaggerViewModelFactory @Inject constructor(private val creators:Map<Class <out ViewModel>,@JvmSuppressWildcards Provider<ViewModel>>):ViewModelProvider.Factory {

    @Suppress
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var creator:Provider<ViewModel>? = creators[modelClass]

        if(creator==null)
            for((key,value) in creators)
            {
                if(modelClass.isAssignableFrom(key)){
                    creator = value
                    break
                }
            }

        if(creator == null) throw IllegalArgumentException("Unknown Model class")
        try {
            return creator.get() as T
        }
        catch (e:Exception)
        {
            throw RuntimeException(e)
        }
    }
}