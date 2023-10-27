package com.example.ultimatechallenge.ui.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ultimatechallenge.R
import com.example.ultimatechallenge.domain.model.Country

class CountryViewHolder (view: View) : RecyclerView.ViewHolder(view) {


    val name = view.findViewById<TextView>(R.id.tvCountry)


    fun render ( country: Country){
        name.text = "${country.name}";
    }
}