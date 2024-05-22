package com.ezegatica.proyectovacio.listeners

import com.ezegatica.proyectovacio.entities.Contacto

interface OnViewItemClickedListener {
    fun onViewItemDetail(contacto: Contacto)
}