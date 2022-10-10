package com.ebookfrenzy.tipcalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.ebookfrenzy.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    @SuppressLint("SetTextI18n")
    fun calculate(view: View){

        val billCost = binding.billAmount.text.toString()

        if(billCost.isNotEmpty()){
            val result = billCost.toBigDecimalOrNull()
            if(result != null){
                //TODO implement conversion here

                //Get in habit of using big decimal with currency to preserve accuracy

                var tip1 = result.multiply(".10".toBigDecimal())
                var tip2 = result.multiply(".15".toBigDecimal())
                var tip3 = result.multiply(".20".toBigDecimal())


                binding.viewTipAmount.text = "The tip are as follow:\n" +
                        "\n" +
                        "10% = " + (result + tip1).toString() + "\n" +
                        "15% = " + (result + tip2).toString() + "\n" +
                        "20% = " + (result + tip3).toString()
            }else{
                //Show this message if illegal value or no value was enter
                binding.viewTipAmount.text = "YOU MUST ENTER A BILL AMOUNT"
            }

        }else{
            //Show this message if illegal value or no value was enter
            binding.viewTipAmount.text = "YOU MUST ENTER A BILL AMOUNT"
        }



    }
}