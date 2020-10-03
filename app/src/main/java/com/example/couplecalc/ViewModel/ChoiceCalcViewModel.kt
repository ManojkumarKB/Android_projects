package com.example.couplecalc.ViewModel

import androidx.lifecycle.ViewModel
import com.example.couplecalc.Component.ActivityScope
import com.example.couplecalc.R
import com.example.couplecalc.View.Calculators.FragmentDisCalculator
import com.example.couplecalc.View.Calculators.FragmentTipCalculator
import javax.inject.Inject

@ActivityScope
class ChoiceCalcViewModel   @Inject constructor():ViewModel() {
    
    fun forTest():String
    {
        return "Choice Activity view model"
        
    }

    fun calDisc(baseAmt:Double,dsAmount:Double):Double
    {
        return baseAmt-dsAmount
    }

    fun calcTipPercent(baseAmt:Double,tipPercent:Int):Double
    {
        return baseAmt * tipPercent/100
    }
    
}