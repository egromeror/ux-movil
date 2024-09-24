package com.example.recordatoriosyalarmasux.lists

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment
import com.example.recordatoriosyalarmasux.R
import java.util.ArrayList

class recordatorio_dialog: DialogFragment()  {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val alertBuilder = AlertDialog.Builder(it)
            var checkedIndex = ArrayList<Int>()

            alertBuilder.setTitle("Recordarme más tarde")
            alertBuilder.setMultiChoiceItems(R.array.recordatorio_list, null, DialogInterface.OnMultiChoiceClickListener{
                    _, index, checked ->
                if(checked){
                    checkedIndex.add(index)
                } else if(checkedIndex.contains(index)){
                    checkedIndex.remove(index)
                }
            })
            alertBuilder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, id ->
                Log.d("DialogLog","OK, pressed check index list $checkedIndex")
            })

            alertBuilder.create()

        }?:throw IllegalStateException("Exception !!Activity null¡¡")
    }
}