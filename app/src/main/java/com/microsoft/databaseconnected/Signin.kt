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

class Signin : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference
    companion object{
    const val KEY1 ="com.microsoft.databaseconnected.Signin.mail"

        const val KEY2 ="com.microsoft.databaseconnected.Signin.name"}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        var signinbutton=findViewById<Button>(R.id.signinbutton)
        var username=findViewById<TextInputLayout>(R.id.usrforsignin)

        val signup=findViewById<TextView>(R.id.signup)
        signup.setOnClickListener(){
            val signupact=Intent(applicationContext,Signup::class.java)
            startActivity(signupact)
        }
        signinbutton.setOnClickListener{
            //take ref till users
            val name=username.toString()
            if(name.isNotEmpty()){
                readData(name) 

            }
            else{
                Toast.makeText(this,"enter  username",Toast.LENGTH_SHORT).show()
            }
        }
    }
  private  fun readData(name: String) {

        databaseReference=FirebaseDatabase.getInstance().getReference("Users")
        databaseReference.child(name).get().addOnSuccessListener {
            if(it.exists()){
                val email=it.child("mail").value
                val name=it.child("name").value
                val intentwelcome=Intent(this,Welcome_activity::class.java)
                intentwelcome.putExtra(KEY1,email.toString())
                intentwelcome.putExtra(KEY2,name.toString())
                startActivity(intentwelcome)
            }
            else{
                Toast.makeText(this,"User doesn't exist,please first sign up",Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener{Toast.makeText(this,"failed️ it's not you it's us",Toast.LENGTH_SHORT).show()}
    }


}
