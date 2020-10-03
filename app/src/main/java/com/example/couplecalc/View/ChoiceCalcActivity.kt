package com.example.couplecalc.View

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.couplecalc.Component.CalcComponent
import com.example.couplecalc.Component.DaggerAppCompon
import com.example.couplecalc.R
import com.example.couplecalc.View.Calculators.FragmentDisCalculator
import com.example.couplecalc.View.Calculators.FragmentTipCalculator
import com.example.couplecalc.ViewModel.ChoiceCalcViewModel
import javax.inject.Inject

class ChoiceCalcActivity : AppCompatActivity()
{
    var isFragmentOneLoaded = true;
    val manager = supportFragmentManager

    lateinit var CalcComponent: CalcComponent

    @Inject
    lateinit var CalcViewModel: ChoiceCalcViewModel

    override fun onCreate(savedInstanceState: Bundle?) {




        setContentView(R.layout.choice_calculator_layout)

   //    CalcComponent =  DaggerAppCompon.create().CalcComponent().create()

        CalcComponent = DaggerAppCompon.create().CalcComponent().create()

        CalcComponent.inject(this)


        super.onCreate(savedInstanceState)

        Log.d("ActivityChceCalculator","onCreate")


        val Change = findViewById<Button>(R.id.btnChngeCalc)

        ShowFragmentOne()

        Change.setOnClickListener({
            if (isFragmentOneLoaded)
                ShowFragmentTwo()
            else
                ShowFragmentOne()
        })
    }

    private fun ShowFragmentTwo() {
        val transaction = manager.beginTransaction()
        val fragment = FragmentTipCalculator()
        transaction.replace(R.id.frameLayout,fragment)
        transaction.replace(R.id.frameLayout,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = false
    }

    private fun ShowFragmentOne() {
        val transaction = manager.beginTransaction()
        val fragment = FragmentDisCalculator()
        transaction.replace(R.id.frameLayout,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = true
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("ActivityChceCalculator","onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ActivityChceCalculator","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ActivityChceCalculator","onStop")
    }

    override fun onStart() {
        super.onStart()
        Log.d("ActivityChceCalculator","onStart")
    }
}