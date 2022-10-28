package com.example.guia3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ActivityLogin : AppCompatActivity() {
    lateinit var btnLogin: Button
    lateinit var btnRegister: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val etUser=findViewById<EditText>(R.id.etUser)
        val etPass=findViewById<EditText>(R.id.etPass)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        btnRegister.setOnClickListener {
            startActivity(Intent(this, ActivityRegister::class.java))
        btnLogin.setOnClickListener {
            startActivity(Intent(this, ActivityHome::class.java))
        }
    }
}}