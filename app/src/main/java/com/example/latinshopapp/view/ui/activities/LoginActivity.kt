package com.example.latinshopapp.view.ui.activities
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

import androidx.fragment.app.FragmentManager
//import com.example.latinshopapp.HomeFragment
import com.example.latinshopapp.R

class LoginActivity : AppCompatActivity() {
    lateinit var Iniciobutton: Button
    lateinit var Registrobutton: TextView
    lateinit var Restaurarbutton: TextView
    private lateinit var firebaseAuth: FirebaseAuth
    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        firebaseAuth=Firebase.auth
        val email=findViewById<EditText>(R.id.loginemail)
        val password=findViewById<EditText>(R.id.loginpassword)
        Iniciobutton=findViewById<Button>(R.id.iniciobutton)
        Registrobutton=findViewById<TextView>(R.id.registrobutton)
        Restaurarbutton=findViewById<TextView>(R.id.restaurarbutton)

        Registrobutton.setOnClickListener(){
            startActivity(Intent(this,RegisterActivity::class.java))
        }

        Iniciobutton.setOnClickListener(){
            login(email.text.toString(), password.text.toString())
        }
        Restaurarbutton.setOnClickListener(){
            startActivity(Intent(this,RestoreActivity::class.java))
        }
    }

    private fun login(email:String, password:String){
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                task->if(task.isSuccessful){
                    val user=firebaseAuth.currentUser
                Toast.makeText(baseContext, user?.uid.toString(), Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,HomeActivity::class.java))
            }else{
                Toast.makeText(baseContext, "Error en usuario y contraseña, por favor verifique sus datos", Toast.LENGTH_SHORT).show()
            }
            }
    }

}