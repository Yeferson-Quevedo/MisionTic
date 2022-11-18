package com.example.latinshopapp.view.ui.activities
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
//import com.example.latinshopapp.HomeFragment
import com.example.latinshopapp.R
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    lateinit var Iniciobutton: Button
    lateinit var Registrobutton: TextView
    lateinit var Restaurarbutton: TextView
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Iniciobutton=findViewById<Button>(R.id.iniciobutton)
        Registrobutton=findViewById<TextView>(R.id.registrobutton)
        Restaurarbutton=findViewById<TextView>(R.id.restaurarbutton)
        val correo= findViewById<EditText>(R.id.editTextEmail)
        val contraseña= findViewById<EditText>(R.id.editTextPassword)
        firebaseAuth= Firebase.auth
        Registrobutton.setOnClickListener(){
            startActivity(Intent(this,RegisterActivity::class.java))
        }
        Iniciobutton.setOnClickListener(){
            login(correo.text.toString(), contraseña.text.toString())
        }
        Restaurarbutton.setOnClickListener(){
            startActivity(Intent(this,RestoreActivity::class.java))
        }
    }
    private fun login(correo:String, contraseña: String){
        firebaseAuth.signInWithEmailAndPassword(correo, contraseña)
            .addOnCompleteListener(this){
                    task->if (task.isSuccessful){
                val user= firebaseAuth.currentUser
                Toast.makeText(baseContext,"Login exitoso, bienvenido ", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, HomeActivity::class.java))
            }else{
                Toast.makeText(baseContext, "Error en autenticación", Toast.LENGTH_SHORT).show()
            }
            }
    }

}