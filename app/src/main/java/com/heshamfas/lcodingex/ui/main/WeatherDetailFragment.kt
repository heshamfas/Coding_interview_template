package com.heshamfas.lcodingex.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.heshamfas.lcodingex.MainActivity
import com.heshamfas.lcodingex.R
import com.heshamfas.lcodingex.entities.Climate
import kotlinx.android.synthetic.main.weather_detail_fragment.*
import kotlinx.android.synthetic.main.weather_list_fragment.*

class WeatherDetailFragment : Fragment() {

    private val TAG by lazy { this::class.java.simpleName }
    private val viewModel: MainViewModel by activityViewModels()
    private val args: WeatherDetailFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.weather_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initUi()
        initObservers()
    }
    private fun initUi(){

    }
    private fun initObservers(){
        viewModel.weatherResponse.observe(viewLifecycleOwner , Observer{
            Log.d(TAG, "Climates are here ${it.climates}")
            displayWeatherDetail(it.climates[args.POSITION])
        })
        viewModel.responseError.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "Error? we shouldn't have come here????")
        })
    }

    private fun displayWeatherDetail(climate: Climate){
        tv_detail_temp.text = climate.main.temp.toInt().toString()
        tv_detail_feels_like.text = getString(R.string.feals_like,climate.main.feels_like.toInt().toString())
        tv_detail_clouds.text = if (climate.weather.isNotEmpty()){climate.weather[0].main} else "Not Available"
    }
}
