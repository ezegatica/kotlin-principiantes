package com.ezegatica.proyectovacio.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ezegatica.proyectovacio.R
import com.ezegatica.proyectovacio.adapters.ContactoListAdapter
import com.ezegatica.proyectovacio.entities.Contacto
import com.ezegatica.proyectovacio.fragments.placeholder.PlaceholderContent

/**
 * A fragment representing a list of Items.
 */
class ItemFragment : Fragment() {

    private var columnCount = 1

    lateinit var recContactos : RecyclerView;

    var contactos : MutableList<Contacto> = ArrayList()

    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var contactoListAdapter: ContactoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)
        recContactos = view.findViewById(R.id.rec_contactos) // cambiar
        /*
        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = ContactoListAdapter(PlaceholderContent.ITEMS)
            }
        }
        */

        return view
    }

    override fun onStart() {
        super.onStart();
        for (i in 1..100) {
            contactos.add(Contacto("Pedro",26, Contacto.Constants.cursoA, "https://images.dog.ceo/breeds/collie-border/n02106166_8037.jpg"))
            contactos.add(Contacto("Rodolfo",30, Contacto.Constants.cursoA, "https://images.dog.ceo/breeds/retriever-golden/Z6A_4904_200816.jpg"))
            contactos.add(Contacto("Emilio",28, Contacto.Constants.cursoB, "https://images.dog.ceo/breeds/deerhound-scottish/n02092002_1592.jpg"))
            contactos.add(Contacto("Luis",37, Contacto.Constants.cursoB, "https://images.dog.ceo/breeds/terrier-cairn/n02096177_2203.jpg"))
            contactos.add(Contacto("Carlos", 42, Contacto.Constants.cursoC, "https://images.dog.ceo/breeds/bulldog-english/murphy.jpg"))
            contactos.add(Contacto("David",21, Contacto.Constants.cursoC, "https://images.dog.ceo/breeds/retriever-flatcoated/n02099267_3272.jpg"))
        }

        requireActivity()

        recContactos.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        contactoListAdapter = ContactoListAdapter(contactos, this)

        recContactos.layoutManager = linearLayoutManager
        recContactos.adapter = contactoListAdapter

    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ItemFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}