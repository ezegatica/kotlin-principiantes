package com.ezegatica.proyectovacio.holders

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ezegatica.proyectovacio.R

class ContactoHolder (v: View) : RecyclerView.ViewHolder(v){
    private var view: View;

    init {
        this.view = v;
    }

    fun setName(name: String) { // Cambiar ID's
        val txt: TextView = view.findViewById(R.id.txt_name_item)
        txt.text = name
    }

    fun setCurso(curso: String){
        val txt: TextView = view.findViewById(R.id.txtCurso)
        txt.text = curso
    }

    fun getCardLayout (): CardView {
        return view.findViewById(R.id.card_package_item)
    }

    fun setOrden(orden: Int){
        val txt: TextView = view.findViewById(R.id.txtOrden)
        txt.text = orden.toString()
    }

}