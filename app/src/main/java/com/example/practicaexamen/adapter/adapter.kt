package com.example.practicaexamen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaexamen.Holder.holder
import entity.Persona
import com.example.practicaexamen.R

class adapter (
    private var incidenteList: MutableList<entity.Persona>,
    val onItemClick: (Int) -> Boolean
): RecyclerView.Adapter<holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_item,parent,false)
        return (holder(view))
    }


    override fun onBindViewHolder(holder: holder, position: Int) {
        holder.setName(incidenteList[position].nombre)
        holder.redirection()



    }

    override fun getItemCount(): Int {
        return  incidenteList.size
    }



    fun setData(newData: ArrayList<entity.Persona>){
        this.incidenteList = newData
        this.notifyDataSetChanged()
    }
}