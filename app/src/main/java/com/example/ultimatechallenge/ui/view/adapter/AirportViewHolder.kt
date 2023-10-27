package com.example.ultimatechallenge.ui.view.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ultimatechallenge.R
import com.example.ultimatechallenge.domain.model.Airport


class AirportViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val iata = view.findViewById<TextView>(R.id.iata)
    val name = view.findViewById<TextView>(R.id.name)
    val city = view.findViewById<TextView>(R.id.city)
    val region = view.findViewById<TextView>(R.id.region)
    fun render ( airport: Airport){
        iata.text = airport.icao;
        name.text = "${airport.name}";
        city.text=  "${airport.city} "
        region.text=  "${airport.region} "

    }
}
