package com.example.unitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.example.unitconverter.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val inputcm=findViewById<TextInputEditText>(R.id.textInputcm)

        val inputM=findViewById<TextInputEditText>(R.id.textInputm)

        if(inputcm!=null){
        binding.btnMeters.setOnClickListener {
            val cm = inputcm.text.toString().toFloat()
            val m = cm * 0.01

            inputM.setText(m.toString())
        }
        }



        if(inputM!=null){
            binding.btnCM.setOnClickListener {
                val m= inputM.text.toString().toFloat()
                val cm= m*100
                inputcm.setText(cm.toString())
            }
        }
    }
}