package com.example.latinshopapp.view.ui.activities
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentManager
//import com.example.latinshopapp.HomeFragment
import com.example.latinshopapp.R

class LoginActivity : AppCompatActivity() {
    lateinit var Iniciobutton: Button
    lateinit var Registrobutton: TextView
    lateinit var Restaurarbutton: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Iniciobutton=findViewById<Button>(R.id.iniciobutton)
        Registrobutton=findViewById<TextView>(R.id.registrobutton)
        Restaurarbutton=findViewById<TextView>(R.id.restaurarbutton)
        Registrobutton.setOnClickListener(){
            startActivity(Intent(this,RegisterActivity::class.java))
        }
        Iniciobutton.setOnClickListener(){

            startActivity(Intent(this,HomeActivity::class.java))
        }
        Restaurarbutton.setOnClickListener(){
            startActivity(Intent(this,RestoreActivity::class.java))
        }
    }
}