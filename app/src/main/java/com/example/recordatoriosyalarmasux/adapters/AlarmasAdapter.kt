package com.example.recordatoriosyalarmasux.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recordatoriosyalarmasux.Alarm
import com.example.recordatoriosyalarmasux.R
import com.google.android.material.switchmaterial.SwitchMaterial

class AlarmasAdapter : RecyclerView.Adapter<AlarmasAdapter.ViewHolder>() {

    var alarmas: MutableList<Alarm>  = ArrayList()
    lateinit var context: Context

    fun AlarmasAdapter(alarmas : MutableList<Alarm>, context: Context){
        this.alarmas = alarmas
        this.context = context
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = alarmas.get(position)
        holder.bind(item, context)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.alarma, parent, false))
    }
    override fun getItemCount(): Int {
        print(alarmas.size)
        return alarmas.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val hora = view.findViewById(R.id.txtHour) as TextView
        val dias = view.findViewById(R.id.txtDays) as TextView
        val tipo = view.findViewById(R.id.swActiva) as SwitchMaterial

        fun bind(alarma:Alarm, context: Context){
            hora.text = alarma.hora
            dias.text = alarma.dias
            tipo.text = alarma.tipo
            tipo.setChecked(alarma.activa)
            itemView.setOnClickListener(View.OnClickListener { Toast.makeText(context, alarma.tipo, Toast.LENGTH_SHORT).show() })
        }
    }
}