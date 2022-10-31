package com.example.latinshopapp.view.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.latinshopapp.R

class RegisterActivity : AppCompatActivity() {
    lateinit var registrobutton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        registrobutton=findViewById(R.id.registrobutton)
        registrobutton.setOnClickListener(){
            startActivity(Intent(this,HomeActivity::class.java))
        }
    }
}