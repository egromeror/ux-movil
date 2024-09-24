package com.example.recordatoriosyalarmasux

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recordatoriosyalarmasux.lists.frecuencia_dialog
import android.widget.TextView
import com.example.recordatoriosyalarmasux.lists.recordatorio_dialog

class crear_alarma : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_crear_alarma)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvFrecuencia = findViewById(R.id.tvFrecuencia) as TextView;
        tvFrecuencia.setOnClickListener {
            showAlertFrecuencia(it)
        }

        val tvRecordarme = findViewById(R.id.tvRecordarme) as TextView;
        tvRecordarme.setOnClickListener {
            showAlertRecordatorio(it)
        }

        val btnCancelar = findViewById(R.id.btnCancelar) as ImageButton;
        btnCancelar.setOnClickListener{
            val intent = Intent(this, listado_alarmas::class.java)
            startActivity(intent)
        }

        val btnGuardar = findViewById(R.id.btnGuardar) as ImageButton;
        btnGuardar.setOnClickListener{
            val intent = Intent(this, listado_alarmas::class.java)
            startActivity(intent)
        }
    }

    fun showAlertFrecuencia(view: View) {
        frecuencia_dialog().show(supportFragmentManager, "frecuencia_dialog ")
    }

    fun showAlertRecordatorio(view: View) {
        recordatorio_dialog().show(supportFragmentManager, "recordatorio_dialog ")
    }
}