package com.example.recordatoriosyalarmasux

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.content.Intent

class Inicio : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnGuest: Button = findViewById(R.id.btnSignGuest)
        btnGuest.setOnClickListener{
            val intent = Intent(this, listado_alarmas::class.java)
            startActivity(intent)
        }

        val btnSesion: Button = findViewById(R.id.btnAdd)
        btnSesion.setOnClickListener{
            val intent = Intent(this, activity_login::class.java)
            startActivity(intent)
        }
    }
}