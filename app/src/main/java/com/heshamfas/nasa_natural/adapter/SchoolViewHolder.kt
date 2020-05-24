package com.heshamfas.nasa_natural.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.heshamfas.nasa_natural.R
import com.heshamfas.nasa_natural.entities.EarthInfo

class SchoolViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    private val tvSchool by lazy { itemView.findViewById<TextView>(R.id.tv_school) }
    private val tvTemp by lazy { itemView.findViewById<TextView>(R.id.tv_tem) }

    fun onBind(
        earthInfo: EarthInfo/*,
        climateDetailOnClickAction: (String, String) -> Unit*/
    ) {

        tvSchool.text = earthInfo.caption

        itemView.setOnClickListener {
            //climateDetailOnClickAction(school.dbn,school.school_name)
        }
        }
    }