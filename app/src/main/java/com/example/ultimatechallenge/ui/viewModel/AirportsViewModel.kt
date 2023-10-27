package com.example.ultimatechallenge.ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ultimatechallenge.domain.DeleteLocalDB
import com.example.ultimatechallenge.domain.GetAirportsUseCase
import com.example.ultimatechallenge.domain.GetAuAirportsUseCase
import com.example.ultimatechallenge.domain.GetBrAirportsUseCase
import com.example.ultimatechallenge.domain.GetEsAirportsUseCase
import com.example.ultimatechallenge.domain.GetFrAirportsUseCase
import com.example.ultimatechallenge.domain.GetGbAirportsUseCase
import com.example.ultimatechallenge.domain.GetItalyAirportsUseCase
import com.example.ultimatechallenge.domain.GetMxAirportsUseCase
import com.example.ultimatechallenge.domain.GetRamdomAirportsUseCase
import com.example.ultimatechallenge.domain.GetUsAirportsUseCase
import com.example.ultimatechallenge.domain.model.Airport
import com.example.ultimatechallenge.domain.model.Country
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AirportsViewModel @Inject constructor(
    private val getAirportsUseCase: GetAirportsUseCase, //Leer de API
    private val getItAirportsUseCase: GetItalyAirportsUseCase, //Leer de la Base
    private val getAuAirportsUseCase: GetAuAirportsUseCase,
    private val getBrAirportsUseCase: GetBrAirportsUseCase,
    private val getFrAirportsUseCase: GetFrAirportsUseCase,
    private val getUsAirportsUseCase: GetUsAirportsUseCase,
    private val getGbAirportsUseCase: GetGbAirportsUseCase,
    private val getEsAirportsUseCase: GetEsAirportsUseCase,
    private val getMxAirportsUseCase: GetMxAirportsUseCase,
    private val deleteLocalDb: DeleteLocalDB
) : ViewModel() {

    val airportsModel = MutableLiveData<List<Airport>>()
    val countryModel = MutableLiveData<List<Country>>()
    val isLoading = MutableLiveData<Boolean>()
    val showTitle = MutableLiveData<Boolean>()
    var countriesList: MutableList<Country> = ArrayList()
    private val _selectedCountry = MutableLiveData<Country>()
    val selectedCountry: LiveData<Country> get() = _selectedCountry


    fun onCountryClicked(country: Country) {
        _selectedCountry.value = country
        showTitle.postValue(false)
        Log.d("country", "País clickeado: ${country.name}")
        when (country.name) {
            "Italia" -> itAirport()
            "Argentina" -> argAirport()
            "España" -> esAirport()
            "Brasil" -> brAirport()
            "Mexico" -> mxAirport()
            "Francia" -> frAirport()
            "Gran Bretaña" -> gbAirport()
            "Australia" -> auAirport()
            "Estados Unidos" -> usAirport()
            "Borrar de BD" ->deleteDB()

        }


    }


    fun onCreate() {
        //Aca creo ese objecto
        showTitle.postValue(true)
        viewModelScope.launch {
            isLoading.postValue(true)
                initCountries()
                countryModel.postValue(countriesList)
                isLoading.postValue(false)

        }
    }

    private fun deleteDB(){
        viewModelScope.launch {
           deleteLocalDb()
            airportsModel.postValue(emptyList())
              showTitle.postValue(true)

        }
    }


    private fun argAirport() {
        airportsModel.postValue(emptyList())
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getAirportsUseCase()

            if (!result.isNullOrEmpty()) {
                airportsModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    private fun itAirport() {
        airportsModel.postValue(emptyList())
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getItAirportsUseCase()

            if (!result.isNullOrEmpty()) {
                airportsModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    private fun auAirport() {
        airportsModel.postValue(emptyList())
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getAuAirportsUseCase()

            if (!result.isNullOrEmpty()) {
                airportsModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    private fun esAirport() {
        airportsModel.postValue(emptyList())
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getEsAirportsUseCase()

            if (!result.isNullOrEmpty()) {
                airportsModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    private fun frAirport() {
        airportsModel.postValue(emptyList())
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getFrAirportsUseCase()

            if (!result.isNullOrEmpty()) {
                airportsModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }


    private fun brAirport() {
        airportsModel.postValue(emptyList())
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getBrAirportsUseCase()

            if (!result.isNullOrEmpty()) {
                airportsModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    private fun mxAirport() {
        airportsModel.postValue(emptyList())
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getMxAirportsUseCase()

            if (!result.isNullOrEmpty()) {
                airportsModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    private fun gbAirport() {
        airportsModel.postValue(emptyList())
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getGbAirportsUseCase()

            if (!result.isNullOrEmpty()) {
                airportsModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    private fun usAirport() {
        airportsModel.postValue(emptyList())
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getUsAirportsUseCase()

            if (!result.isNullOrEmpty()) {
                airportsModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    private fun initCountries(){
        countriesList.add(Country("Argentina"))
        countriesList.add(Country("Australia"))
        countriesList.add(Country("Francia"))
        countriesList.add(Country("Italia"))
        countriesList.add(Country("Gran Bretaña"))
        countriesList.add(Country("Mexico"))
        countriesList.add(Country("España"))
        countriesList.add(Country("Brasil"))
        countriesList.add(Country("Estados Unidos"))
        countriesList.add(Country("Borrar de BD"))


    }


}