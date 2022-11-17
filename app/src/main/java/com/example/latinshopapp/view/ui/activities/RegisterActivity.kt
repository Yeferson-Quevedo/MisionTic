package com.example.latinshopapp.view.ui.activities

import android.annotation.SuppressLint
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

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        registrobutton = findViewById(R.id.registrobutton)
        firebaseAuth = Firebase.auth
        registrobutton.setOnClickListener() {
            startActivity(Intent(this, HomeActivity::class.java))
            val correo= findViewById<EditText>(R.id.Correo)
            val contraseña= findViewById<EditText>(R.id.Password)
        registrobutton.setOnClickListener{
            crearcuenta(correo.text.toString(), contraseña.text.toString())
        }

        }

    }
    private fun crearcuenta(correo: String, contraseña: String) {
        firebaseAuth.createUserWithEmailAndPassword(correo, contraseña)
            .addOnCompleteListener(this) { Task ->
                if (Task.isSuccessful) {
                    Toast.makeText(baseContext, "Cuenta Creada", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,HomeActivity::class.java))
                }else{
                    Toast.makeText(baseContext, "Error de creacion", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
