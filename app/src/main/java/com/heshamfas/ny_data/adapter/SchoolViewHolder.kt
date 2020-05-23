package com.heshamfas.ny_data.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.heshamfas.ny_data.R
import com.heshamfas.ny_data.entities.NYSchool

class SchoolViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    private val tvSchool by lazy { itemView.findViewById<TextView>(R.id.tv_school) }
    private val tvTemp by lazy { itemView.findViewById<TextView>(R.id.tv_tem) }

    fun onBind(
        school: NYSchool,
        climateDetailOnClickAction: (String, String) -> Unit
    ) {

        tvSchool.text = school.school_name

        itemView.setOnClickListener {
            climateDetailOnClickAction(school.dbn,school.school_name)
        }
        }
    }