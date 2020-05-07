package com.heshamfas.lcodingex.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

import com.heshamfas.lcodingex.R
import com.heshamfas.lcodingex.adapter.WeatherListAdapter
import com.heshamfas.lcodingex.entities.Climate
import kotlinx.android.synthetic.main.weather_list_fragment.*

class WeatherListFragment : Fragment() {
    private val TAG by lazy { this::class.java.simpleName }
    private val args: WeatherListFragmentArgs by navArgs()


    private val viewModel: MainViewModel by activityViewModels{VMFactory(args.cityName)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.weather_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initUi()
        initObservers()
    }

    override fun onResume() {
        super.onResume()
        tv_error.visibility = View.GONE
    }
   private fun initUi(){
    }
    private fun initObservers(){
        viewModel.weatherResponse.observe(viewLifecycleOwner , Observer{
            tv_error.visibility = View.GONE
            Log.d(TAG, "Climates are here ${it.climates}")
            processClimates(it.climates)
        })
        viewModel.responseError.observe(viewLifecycleOwner, Observer {
                showError(it)
        })
    }

    private fun showError(error: Throwable){
        tv_error.visibility = View.VISIBLE
        tv_error.text = "${getString(R.string.request_error)}  \n ${error?.localizedMessage}"
    }

    private fun processClimates(climates: List<Climate>?) {
        if (!climates.isNullOrEmpty()) {
            Log.d(TAG, "climates are here ${climates.count()}")
            rv_city_weather.adapter = WeatherListAdapter(
                climates.toMutableList(),
                gotoDetails
            )
        } else {
           //showNoInfoUi()
        }
    }
    private val gotoDetails = fun(position: Int){
       goToClimateDetail(position)
    }
    private fun goToClimateDetail(position: Int){
        val action = WeatherListFragmentDirections.actionWeatherListFragmentToWeatherDetailFragment(args.cityName,position)
        findNavController().navigate(action)
    }
}
