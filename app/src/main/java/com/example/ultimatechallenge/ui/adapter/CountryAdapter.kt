package com.example.ultimatechallenge.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ultimatechallenge.R
import com.example.ultimatechallenge.domain.model.Airport
import com.example.ultimatechallenge.domain.model.Country
import com.example.ultimatechallenge.ui.view.adapter.AirportViewHolder

class CountryAdapter (private val countryList: MutableList<Country> = mutableListOf()) : RecyclerView.Adapter<CountryViewHolder>() {

    private var onItemClick: ((Country) -> Unit)? = null

    // Método para actualizar los datos
    fun updateData(newData: List<Country>) {
        countryList.clear() // Limpia la lista actual
        countryList.addAll(newData) // Agrega los nuevos datos

        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_btn, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countryList[position]
        holder.render(country)
        holder.itemView.setOnClickListener {

            onItemClick?.invoke(country)
        }
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    fun setOnItemClickListener(listener: (Country) -> Unit) {
        onItemClick = listener
    }

}