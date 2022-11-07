package com.example.latinshopapp.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
//import com.example.latinshopapp.view.ui.activities.fragments
import android.os.Bundle
import com.example.latinshopapp.R
import com.example.latinshopapp.view.ui.activities.fragments.CatalogoFragment

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //con este abrimos los fragments el fragment home
        supportFragmentManager.beginTransaction().replace(R.id.nav_container,CatalogoFragment()).commit()
    }
}