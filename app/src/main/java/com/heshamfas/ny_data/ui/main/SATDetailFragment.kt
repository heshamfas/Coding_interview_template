package com.heshamfas.ny_data.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.heshamfas.ny_data.R
import com.heshamfas.ny_data.entities.SAT
import com.heshamfas.ny_data.entities.SATItem
import kotlinx.android.synthetic.main.sat_detail_fragment.*

class SATDetailFragment : Fragment() {

    private val TAG by lazy { this::class.java.simpleName }
    private val args: SATDetailFragmentArgs by navArgs()
    private val viewModel: SATViewModel by activityViewModels{ VMFactory(args.schoolId)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sat_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initUi()
        initObservers()
    }
    private fun initUi(){

    }
    private fun initObservers(){
        viewModel.satInfo.observe(viewLifecycleOwner , Observer{
          Log.d(TAG, "SATs are here $it")
            if(it.size>0)
                displaySATDetail(it[0])
        })
        viewModel.responseError.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "Error? we shouldn't have come here????")
        })
    }

    private fun displaySATDetail(school:SATItem){
        tv_num_of_sat_test_takers.text = school.num_of_sat_test_takers
        tv_sat_critical_reading_avg_score.text = school.sat_critical_reading_avg_score
        tv_sat_math_avg_score.text = school.sat_math_avg_score
        tv_sat_writing_avg_score.text = school.sat_math_avg_score

    }
}
