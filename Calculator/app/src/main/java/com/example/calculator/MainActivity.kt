package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    private var input=""
    private var operand1: Double=0.0
    private var operator=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn0.setOnClickListener { appendNumber("0") }
        binding.btn1.setOnClickListener { appendNumber("1") }
        binding.btn2.setOnClickListener { appendNumber("2") }
        binding.btn3.setOnClickListener { appendNumber("3") }
        binding.btn4.setOnClickListener { appendNumber("4") }
        binding.btn5.setOnClickListener { appendNumber("5") }
        binding.btn6.setOnClickListener { appendNumber("6") }
        binding.btn7.setOnClickListener { appendNumber("7") }
        binding.btn8.setOnClickListener { appendNumber("8") }
        binding.btn9.setOnClickListener { appendNumber("9") }
        binding.btn0.setOnClickListener { appendNumber("0") }
        binding.btn00.setOnClickListener { appendNumber("00") }

        //Operator
        binding.btnadd.setOnClickListener { setOperator("+") }
        binding.btnsub.setOnClickListener { setOperator("-") }
        binding.btnmult.setOnClickListener { setOperator("*") }
        binding.btndivide.setOnClickListener { setOperator("/") }

        //Equals
        binding.btnequal.setOnClickListener { calculateResult() }

        //Clear Button
        binding.btnC.setOnClickListener { clearCalucalator() }

    }

    private fun appendNumber(number: String) {
        input+=number
        binding.txtInput.text=input
    }

    private fun setOperator(op: String) {
        operator=op
        operand1=input.toDouble()
        binding.txtInput.text = "$operand1 $operator "
        input=""
    }

    private fun calculateResult() {
        val operand2=input.toDouble()
        var result=0.0

        when(operator){
            "+" -> result=operand1 + operand2
            "-" -> result= operand1 - operand2
            "*" -> result= operand1 * operand2
            "/" -> result= operand1 / operand2

        }
        binding.txtResult.text=result.toString()
    }

    private fun clearCalucalator() {
        input=""
        operand1=0.0
        operator=""
        binding.txtResult.text=""
        binding.txtInput.text=""
    }
}
//%,() Not Functioning because code is not written