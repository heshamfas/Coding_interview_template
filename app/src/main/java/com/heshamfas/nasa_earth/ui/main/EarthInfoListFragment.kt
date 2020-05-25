package com.heshamfas.nasa_earth.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.heshamfas.nasa_earth.R
import com.heshamfas.nasa_earth.adapter.EarthInfoListAdapter
import com.heshamfas.nasa_earth.entities.EarthInfo
import kotlinx.android.synthetic.main.earth_info_list_fragment.*

class EarthInfoListFragment : Fragment() {
    private val TAG by lazy { this::class.java.simpleName }
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.earth_info_list_fragment, container, false)
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
        viewModel.nasaNatural.observe(viewLifecycleOwner , Observer{
            tv_error.visibility = View.GONE
            Log.d(TAG, "earth info is here ${it}")
            processEarthList(it)
        })
        viewModel.responseError.observe(viewLifecycleOwner, Observer {
                showError(it)
        })
    }

    private fun showError(error: Throwable){
        tv_error.visibility = View.VISIBLE
        tv_error.text = "${getString(R.string.request_error)}  \n ${error?.localizedMessage}"
    }

    private fun processEarthList(earthInfo: List<EarthInfo>?) {
        if (!earthInfo.isNullOrEmpty()) {
            Log.d(TAG, "earth info is here ${earthInfo.count()}")
            rv_earth_info.adapter = EarthInfoListAdapter(
                earthInfo.toMutableList())
        } else {
           //showNoInfoUi()
        }
    }
}