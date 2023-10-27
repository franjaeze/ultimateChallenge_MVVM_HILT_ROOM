package com.example.ultimatechallenge.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ultimatechallenge.R
import com.example.ultimatechallenge.domain.model.Airport


class AirportAdapter(private val airportsList: MutableList<Airport> = mutableListOf()) : RecyclerView.Adapter<AirportViewHolder>() {

    // Método para actualizar los datos
    fun updateData(newData: List<Airport>) {
        airportsList.clear() // Limpia la lista actual
        airportsList.addAll(newData) // Agrega los nuevos datos

        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AirportViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_airports, parent, false)
        return AirportViewHolder(view)
    }

    override fun onBindViewHolder(holder: AirportViewHolder, position: Int) {
        val airport = airportsList[position]
        holder.render(airport)
//        holder.itemView.setOnClickListener {
//
//            onPersonajeClickListener?.OnClickNavigate(personaje)
//        }
    }

    override fun getItemCount(): Int {
        return airportsList.size
    }

//    fun setOnPersonajeClickListener (listener: OnClickNavigate) {
//        onPersonajeClickListener = listener
//    }

}
