package com.microsoft.databaseconnected

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Signup : AppCompatActivity() {
     lateinit var database:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val signup=findViewById<Button>(R.id.button)
        val signin=findViewById<TextView>(R.id.signin)
        val etname=findViewById<TextInputEditText>(R.id.usr)
        val gmail=findViewById<TextInputEditText>(R.id.mail)
        val pwd=findViewById<TextInputEditText>(R.id.pwd)
        signin.setOnClickListener {
            val intent = Intent(this@Signup, Signin::class.java)
            startActivity(intent)
        }

        signup.setOnClickListener(){
            val name=etname.text.toString()
            val mail=gmail.text.toString()
            val password=pwd.text.toString()
            database=FirebaseDatabase.getInstance().getReference(
                    "Users"
                    )
            val user =Users(name,mail,password)
            database.child(name).setValue(user).addOnSuccessListener { Toast.makeText(this,"user registered",Toast.LENGTH_SHORT).show()
            etname.text?.clear()
            gmail.text?.clear()
                pwd.text?.clear()
            }.addOnFailureListener { Toast.makeText(this,"failed",Toast.LENGTH_SHORT).show() }
        }

    }
}