package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class Signin : AppCompatActivity() {

    private lateinit var databaseReference: DatabaseReference
    //lateinit var etemail: TextInputEditText
    //lateinit var etpass: TextInputEditText

    //lateinit var auth: FirebaseAuth
    companion object{
        const val KEY1= "com.example.todo.Signin.name"
        const val KEY2= "com.example.todo.Signin.email"
        const val KEY3= "com.example.todo.Signin.pass"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val etemail=findViewById<TextInputEditText>(R.id.signinemail)
        val etpass=findViewById<TextInputEditText>(R.id.signinpass)
        val btnsignin=findViewById<Button>(R.id.signin)

        /*auth = FirebaseAuth.getInstance()
        btnsignin.setOnClickListener {

            login()


            }
        }

    private fun login() {
        val email=etemail.text.toString()
        val pass=etpass.text.toString()

        auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this) {
            if(it.isSuccessful) {
                Toast.makeText(this, "Successfully Login", Toast.LENGTH_SHORT).show()

                val todo= Intent(this,ToDo::class.java)
                startActivity(todo)
            }
            else {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        }*/




        btnsignin.setOnClickListener {
            val password=etpass.text.toString()
            if(password.isNotEmpty()){
                    readData(password)
            }
            else
            {
                Toast.makeText(this, "Please enter correct Password", Toast.LENGTH_SHORT).show()
            }
        }



    }

    private fun readData(password: String) {
        databaseReference=FirebaseDatabase.getInstance().getReference("To Do")

        databaseReference.child(password).get().addOnSuccessListener {
            if(it.exists()){
                val name=it.child("name").value
                val todoactivity=Intent(this,ToDo::class.java)
                todoactivity.putExtra(KEY1,name.toString())
                startActivity(todoactivity)
            }
            else
            {
                Toast.makeText(this, "User Does not exist", Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
        }
    }

}


