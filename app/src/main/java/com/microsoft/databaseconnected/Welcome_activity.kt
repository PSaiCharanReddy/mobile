package com.microsoft.databaseconnected

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Welcome_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val name=intent.getStringExtra(Signin.KEY2)
        val mail=intent.getStringExtra(Signin.KEY1)
        val welcomeText=findViewById<TextView>(R.id.tvwelcome)
        welcomeText.text="Welcome $name"
        val btnmail=findViewById<Button>(R.id.btnmail)
        val btnname=findViewById<Button>(R.id.btnname)
        btnmail.text=mail
        btnname.text=name



    }
}