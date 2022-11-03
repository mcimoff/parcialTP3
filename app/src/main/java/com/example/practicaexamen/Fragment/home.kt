package com.example.practicaexamen.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaexamen.R
import com.example.practicaexamen.adapter.adapter
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

lateinit var vistaHome : View
var personas: MutableList<Persona> = ArrayList<Persona>();
lateinit var listpersonas: RecyclerView
lateinit var personaListAdapter: adapter
lateinit var  linearLayoutManager: LinearLayoutManager;
lateinit var  buttonGoToLogin: Button


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

        listpersonas = vistaHome.findViewById((R.id.recycleHome))

        buttonGoToLogin = vistaHome.findViewById((R.id.buttonGoToLogin))

        return vistaHome
    }

    override fun onStart() {
        super.onStart()

        buttonGoToLogin.setOnClickListener {

           var action = homeDirections.actionFragmentHomeToActivityLogin()

            vistaHome.findNavController().navigate(action)
        }

        for (i in 1..5) {
            personas.add(Persona("Raul", "Bulldog", 5))
            personas.add(Persona("Fabian", "Cocker", 2))
            personas.add(Persona("Maria", "Labrador", 7))
            personas.add(Persona("Pancho", "Salchicha", 4))
        }

        listpersonas.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)

        listpersonas.layoutManager = linearLayoutManager

        personaListAdapter = adapter(personas) { x ->
            onItemClick(x)


        }

        listpersonas.adapter = personaListAdapter

    }


    fun onItemClick (position: Int): Boolean{
        Snackbar.make(vistaHome,position.toString(), Snackbar.LENGTH_SHORT).show()
        personas[position]
        return true
    }





}