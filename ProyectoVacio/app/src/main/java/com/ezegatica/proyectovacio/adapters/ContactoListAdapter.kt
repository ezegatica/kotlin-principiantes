package com.ezegatica.proyectovacio.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

import com.ezegatica.proyectovacio.fragments.placeholder.PlaceholderContent.PlaceholderItem
import com.ezegatica.proyectovacio.databinding.FragmentItemBinding
import com.ezegatica.proyectovacio.entities.Contacto
import com.ezegatica.proyectovacio.holders.ContactoHolder
import com.ezegatica.proyectovacio.R
import com.ezegatica.proyectovacio.listeners.OnViewItemClickedListener

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class ContactoListAdapter(
    private val values: MutableList<Contacto>,
    private val onItemClick: OnViewItemClickedListener
) : RecyclerView.Adapter<ContactoHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.fragment_item,parent,false) // Cambiar  ID's
        return (ContactoHolder(view))
    }

    override fun onBindViewHolder(holder: ContactoHolder, position: Int) {
        val item = values[position]
        holder.setName(item.nombre)
        holder.setCurso(item.edad.toString());

        holder.getCardLayout().setOnClickListener{
            onItemClick.onViewItemDetail(item)
        }
    }

    override fun getItemCount(): Int = values.size
}