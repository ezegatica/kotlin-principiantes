package com.ezegatica.proyectovacio.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

import com.ezegatica.proyectovacio.fragments.placeholder.PlaceholderContent.PlaceholderItem
import com.ezegatica.proyectovacio.databinding.FragmentItemBinding
import com.ezegatica.proyectovacio.entities.Contacto
import com.ezegatica.proyectovacio.holders.ContactoHolder

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class ContactoListAdapter(
    private val values: MutableList<Contacto>
) : RecyclerView.Adapter<ContactoHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_contactos,parent,false) // Cambiar  ID's
        return (ContactoHolder(view))
    }

    override fun onBindViewHolder(holder: ContactoHolder, position: Int) {
        val item = values[position]
        holder.setName(item.nombre)
        holder.setCurso(item.edad.toString());
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}