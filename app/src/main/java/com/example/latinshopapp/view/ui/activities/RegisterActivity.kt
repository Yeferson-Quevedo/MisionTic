package com.example.latinshopapp.view.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.latinshopapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {
    lateinit var registrobutton: Button
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        firebaseAuth= Firebase.auth
        registrobutton=findViewById(R.id.registrobutton)
        val email=findViewById<EditText>(R.id.registroemail)
        val password = findViewById<EditText>(R.id.registropassword)
        registrobutton.setOnClickListener(){
            crearcuenta(email.text.toString(), password.text.toString())
        }
    }
    private fun crearcuenta(email:String,password:String){
        firebaseAuth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){
                Task->if(Task.isSuccessful){
                    Toast.makeText(baseContext, "Tu cuenta está creada", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,HomeActivity::class.java))
                }else{
                    Toast.makeText(baseContext,"Error en la creación de tu cuenta", Toast.LENGTH_SHORT).show()
                }
            }
    }
}