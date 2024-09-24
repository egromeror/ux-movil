package com.example.recordatoriosyalarmasux

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recordatoriosyalarmasux.adapters.AlarmasAdapter

class listado_alarmas : AppCompatActivity() {
    lateinit var mRecyclerView : RecyclerView
    val mAdapter : AlarmasAdapter = AlarmasAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_listado_alarmas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnAdd: Button = findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener{
            val intent = Intent(this, crear_alarma::class.java)
            startActivity(intent)
        }

        setUpRecyclerView()
    }

    fun getAlarmas(): MutableList<Alarm>{
        var alarmas:MutableList<Alarm> = ArrayList()
        alarmas.add(Alarm("5:00 a.m.", "Lun, mie, vie","Gimnasio",true))
        alarmas.add(Alarm("6:30 a.m.", "Lun, mar, mie, jue, vie","Laboral",true))
        alarmas.add(Alarm("8:00 a.m.", "Mie","Reunión",true))
        alarmas.add(Alarm("12:30 p.m.", "Lun, mie, vie","Medicamento",true))
        alarmas.add(Alarm("5:00 a.m.", "Lun, mie, vie","Gimnasio",true))
        return alarmas
    }

    fun setUpRecyclerView(){
        mRecyclerView = findViewById(R.id.rvAlarmas) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter.AlarmasAdapter(getAlarmas(), this)
        mRecyclerView.adapter = mAdapter
    }
}