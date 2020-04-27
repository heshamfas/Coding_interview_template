package com.heshamfas.lcodingex.adapter

import android.app.Application
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.heshamfas.lcodingex.R
import com.heshamfas.lcodingex.entities.Climate

class ClimateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    private val tvWeather by lazy { itemView.findViewById<TextView>(R.id.tv_climate) }
    private val tvTemp by lazy { itemView.findViewById<TextView>(R.id.tv_tem) }

    fun onBind(
        climate: Climate,
        climateDetailOnClickAction: (Int) -> Unit
    ) {

        tvWeather.text = climate.weather[0].main
        tvTemp.text = itemView.context.getString(R.string.temp, climate.main.temp.toString())

        itemView.setOnClickListener {
            climateDetailOnClickAction(adapterPosition)
        }
        }
    }