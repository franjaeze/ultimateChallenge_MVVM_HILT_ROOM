package com.example.ultimatechallenge.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ultimatechallenge.databinding.ActivityMainBinding
import com.example.ultimatechallenge.domain.model.Country
import com.example.ultimatechallenge.ui.adapter.CountryAdapter
import com.example.ultimatechallenge.ui.view.adapter.AirportAdapter
import com.example.ultimatechallenge.ui.viewModel.AirportsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var rvAdapter: AirportAdapter
    private lateinit var rvCountryAdapter: CountryAdapter

    private val airportsViewModel: AirportsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvAdapter = AirportAdapter()
        rvCountryAdapter = CountryAdapter()
        rvCountryAdapter.setOnItemClickListener { country ->
        airportsViewModel.onCountryClicked(country)

        }
        airportsViewModel.onCreate()



        airportsViewModel.airportsModel.observe(this, Observer {
//            binding.rvAirports.adapter = rvAdapter.it

            rvAdapter.updateData(it)
        })
        airportsViewModel.countryModel.observe(this, Observer {
//            binding.rvAirports.adapter = rvAdapter.it

            rvCountryAdapter.updateData(it)
        })

        airportsViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })

        airportsViewModel.showTitle.observe(this, Observer {
            binding.tvTitle.isVisible = it
        })


    }


    override fun onStart() {
        super.onStart()
        initRecycleView()
        initRvCountry()


    }


    fun initRecycleView(){
        val recycleView = binding.rvAirports
        recycleView.layoutManager = LinearLayoutManager(this@MainActivity)

    //    rvAdapter.updateData(airportsViewModel.airportsModel.value ?: emptyList())
        recycleView.adapter = rvAdapter

    }


    fun initRvCountry(){
        val recycleView = binding.rvCountry
        recycleView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        //    rvAdapter.updateData(airportsViewModel.airportsModel.value ?: emptyList())
        recycleView.adapter = rvCountryAdapter


    }


}