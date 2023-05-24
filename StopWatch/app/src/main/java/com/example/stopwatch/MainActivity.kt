package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var running: Boolean=false
    private var seconds: Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState!=null)
        {
            seconds=savedInstanceState.getInt("seconds")
            running=savedInstanceState.getBoolean("running")
        }
        val startbutton=findViewById<Button>(R.id.btnstart)
        val stopbutton=findViewById<Button>(R.id.btnstop)
        val resetbutton=findViewById<Button>(R.id.btnreset)

        startbutton.setOnClickListener {
            running=true
            startbutton.visibility= View.VISIBLE
            stopbutton.visibility= View.VISIBLE
        }

        stopbutton.setOnClickListener {
            running = false
            startbutton.visibility= View.VISIBLE
            stopbutton.visibility= View.VISIBLE
        }

        resetbutton.setOnClickListener {
            running=false
            seconds=0
            startbutton.visibility= View.VISIBLE
            stopbutton.visibility= View.VISIBLE
        }

        runtimer()


    }

    private fun runtimer() {
        val handler=Handler()
        handler.post(object : Runnable{
            override fun run() {
                val hours =seconds/3600
                val minutes= (seconds%3600)/60
                val secs=seconds%60

                val time= String.format("%d:%02d:%02d",hours,minutes,secs)

                val timer=findViewById<TextView>(R.id.stopwatch)
                timer.text=time

                if(running){
                    seconds++
                }
                handler.postDelayed(this,1000)
            }
        })
    }
}