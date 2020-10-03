package com.example.couplecalc.View.Calculators

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import com.example.couplecalc.R
import com.example.couplecalc.View.ChoiceCalcActivity
import com.example.couplecalc.ViewModel.ChoiceCalcViewModel
import kotlinx.android.synthetic.main.disccalculator.*
import javax.inject.Inject

private const val INITIAL_TIP_PERCENT =50
class FragmentDisCalculator : Fragment()
{
    var TAG ="DisFragment"

    @Inject lateinit var CalcViewModel: ChoiceCalcViewModel


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as ChoiceCalcActivity).CalcComponent.inject(this)
        Log.d(TAG,"onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG,"onContentView")
        return inflater!!.inflate(R.layout.disccalculator,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG,"onActivityCreated")
        seekBarTip.progress = INITIAL_TIP_PERCENT
        tvDsPercent.text ="50%"
        seekBarTip.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener
        {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Log.i(TAG,"onProgressChanged $progress")
                tvDsPercent.text = "$progress%"
                computeTipAndTotal();
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        tfBaseLabel.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                Log.i(TAG,"afterTextChanged $s")
                computeTipAndTotal()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG,"onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG,"onDetach")
    }

    private fun computeTipAndTotal() {

        //calculating the total and tip percentage
        if(tfBaseLabel.text.toString().isEmpty())
        {
            tvTextView.text = "";
            tvTotalAmount.text = "";
            return;
        }
        val baseAmt = tfBaseLabel.text.toString().toDouble();
        val tipPercent = seekBarTip.progress;
        val dsAmount = baseAmt * tipPercent/100;
        val totalAmount = CalcViewModel.calDisc(baseAmt,dsAmount)
        tvTextView.text = "%.2f".format(dsAmount);
        tvTotalAmount.text = "%.2f".format(totalAmount);

    }

}