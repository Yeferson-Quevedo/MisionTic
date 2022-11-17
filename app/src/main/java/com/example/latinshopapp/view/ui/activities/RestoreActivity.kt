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

class RestoreActivity : AppCompatActivity() {
    lateinit var restaurarbutton: Button
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restore)
        firebaseAuth = Firebase.auth
        restaurarbutton = findViewById(R.id.restaurarbutton)
        val correo = findViewById<EditText>(R.id.editTextEmail)
        restaurarbutton.setOnClickListener{
            cambioContrasena(correo.text.toString())
        }
    }
        private fun cambioContrasena(correo:String) {
            firebaseAuth.sendPasswordResetEmail(correo)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            baseContext,
                            "Correo de cambio de contraseña enviado",
                            Toast.LENGTH_SHORT
                        ).show()
                        startActivity(Intent(this, HomeActivity::class.java))
                    }else{
                        Toast.makeText(baseContext, "Error valida el correo, por favor", Toast.LENGTH_SHORT).show()
                    }
                }
        }}

