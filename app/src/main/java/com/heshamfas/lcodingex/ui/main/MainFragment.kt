package com.heshamfas.lcodingex.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.heshamfas.lcodingex.MainActivity
import com.heshamfas.lcodingex.R
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initUI()
    }

    private fun initUI(){
        showToobar(false)
        btn_main_lookup.setOnClickListener {
            if(!et_main_city_lookup.text.toString().isBlank()){
                gotoClimateListFragment(et_main_city_lookup.text.toString())
            }
        }
    }

    private fun gotoClimateListFragment(city: String){
     val action:NavDirections = MainFragmentDirections.actionMainFragmentToWeatherListFragment(city)
        findNavController().navigate(action)
        showToobar(true)
    }

    private fun showToobar(show:Boolean){
        (activity as MainActivity).showToolbar(show)
    }
}
