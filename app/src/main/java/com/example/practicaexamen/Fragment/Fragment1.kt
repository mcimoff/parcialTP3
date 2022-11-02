package com.example.practicaexamen.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import com.example.practicaexamen.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var vistaInicio: View
    lateinit var buttonGoToHome: Button

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
        // Inflate the layout for this fragment

        vistaInicio = inflater.inflate(R.layout.fragment_1, container, false)

        buttonGoToHome = vistaInicio.findViewById((R.id.buttonGoToHome))

        return vistaInicio
    }

    override fun onStart() {
        super.onStart()

        buttonGoToHome.setOnClickListener {

              var action = Fragment1Directions.actionFragment1ToHome2(1)
              vistaInicio.findNavController().navigate(action)
        }
    }



}