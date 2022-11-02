package com.example.practicaexamen.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaexamen.Persona
import com.example.practicaexamen.R
import com.example.practicaexamen.adapter.adapter
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

lateinit var vistaHome : View
var personas: MutableList<Persona> = ArrayList<Persona>();
lateinit var listPersona: RecyclerView
lateinit var personaListAdapter: adapter
lateinit var  linearLayoutManager: LinearLayoutManager;
lateinit var switch : Switch

/**
 * A simple [Fragment] subclass.
 * Use the [home.newInstance] factory method to
 * create an instance of this fragment.
 */
class home : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vistaHome = inflater.inflate(R.layout.fragment_home, container, false)

        listPersona = vistaHome.findViewById((R.id.recycleHome))
        switch = vistaHome.findViewById((R.id.switch1))

        return vistaHome
    }

    override fun onStart() {
        super.onStart()


        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                switch.text = "Activo"
            } else {
                switch.text = "Inactivo"
            }
        }

        for (i in 1..5){
            personas.add(Persona("Raul"))
            personas.add(Persona("Fabian"))
            personas.add(Persona("Maria"))
            personas.add(Persona("Beatriz"))
        }

        listPersona.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)

        listPersona.layoutManager = linearLayoutManager

        personaListAdapter = adapter(personas) { x ->
            onItemClick(x)
        }

        listPersona.adapter = personaListAdapter
    }

    fun onItemClick (position: Int): Boolean{
        Snackbar.make(vistaHome,position.toString(), Snackbar.LENGTH_SHORT).show()
        return true
    }
}