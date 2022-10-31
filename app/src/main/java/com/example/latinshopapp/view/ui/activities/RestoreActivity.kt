package com.example.latinshopapp.view.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.latinshopapp.R

class RestoreActivity : AppCompatActivity() {
    lateinit var restaurarbutton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restore)
        restaurarbutton=findViewById(R.id.restaurarbutton)
        restaurarbutton.setOnClickListener(){
            startActivity(Intent(this,HomeActivity::class.java))
        }
    }
}