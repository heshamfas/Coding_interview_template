package com.heshamfas.nasa_natural.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

import com.heshamfas.nasa_natural.R
import com.heshamfas.nasa_natural.adapter.SchoolListAdapter
import com.heshamfas.nasa_natural.entities.EarthInfo
import kotlinx.android.synthetic.main.school_list_fragment.*

class NaturalListFragment : Fragment() {
    private val TAG by lazy { this::class.java.simpleName }
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.school_list_fragment, container, false)
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
            processClimates(it)
        })
        viewModel.responseError.observe(viewLifecycleOwner, Observer {
                showError(it)
        })
    }

    private fun showError(error: Throwable){
        tv_error.visibility = View.VISIBLE
        tv_error.text = "${getString(R.string.request_error)}  \n ${error?.localizedMessage}"
    }

    private fun processClimates(climates: List<EarthInfo>?) {
        if (!climates.isNullOrEmpty()) {
            Log.d(TAG, "climates are here ${climates.count()}")
            rv_ny_city_school.adapter = SchoolListAdapter(
                climates.toMutableList(),
                gotoDetails
            )
        } else {
           //showNoInfoUi()
        }
    }
    private val gotoDetails = fun(dbn:String, name:String){
       goToClimateDetail(dbn,name)
    }
    private fun goToClimateDetail(dbn:String, name:String){
   /*         val directions:NavDirections = SchoolListFragmentDirections.actionSchoolListFragmentToSatDetailFragment(dbn,name)
        findNavController().navigate(directions)*/
    }
}
