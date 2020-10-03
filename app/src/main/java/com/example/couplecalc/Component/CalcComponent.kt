package com.example.couplecalc.Component

import com.example.couplecalc.View.Calculators.FragmentDisCalculator
import com.example.couplecalc.View.Calculators.FragmentTipCalculator
import com.example.couplecalc.View.MainActivity
import com.example.couplecalc.View.ChoiceCalcActivity
import com.example.couplecalc.ViewModel.LoginViewModel

import dagger.Subcomponent
import javax.inject.Scope

@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class ActivityScope


@ActivityScope
@Subcomponent
interface CalcComponent {

    @Subcomponent.Builder
    interface Builder {
        fun create(): CalcComponent
    }

    fun inject(activity: ChoiceCalcActivity)

    fun inject(ChoiceCalcViewModel: LoginViewModel)
    fun inject(discFragment: FragmentDisCalculator)
    fun inject(tipFragment: FragmentTipCalculator)
}