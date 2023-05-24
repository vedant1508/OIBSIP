package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signup=findViewById<Button>(R.id.btnsignup)
        val etname=findViewById<TextInputEditText>(R.id.name)
        val etemail=findViewById<TextInputEditText>(R.id.email)
        val etpass=findViewById<TextInputEditText>(R.id.pass)
        val signin=findViewById<TextView>(R.id.txtsignin)


        signup.setOnClickListener {
            val name=etname.text.toString()
            val email=etemail.text.toString()
            val password=etpass.text.toString()

            val user=User(name,email,password)

            database=FirebaseDatabase.getInstance().getReference("To Do")

            database.child(password).setValue(user).addOnSuccessListener {

                etname.text?.clear()
                etemail.text?.clear()
                etpass.text?.clear()

                Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()
                val todoactivity=Intent(this,ToDo::class.java)
                startActivity(todoactivity)
            }.addOnFailureListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
        }

        signin.setOnClickListener {
            val opensigninactivity=Intent(this,Signin::class.java)
            startActivity(opensigninactivity)
        }
    }
}