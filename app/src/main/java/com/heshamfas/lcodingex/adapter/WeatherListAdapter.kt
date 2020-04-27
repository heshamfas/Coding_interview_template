package com.heshamfas.lcodingex.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.heshamfas.lcodingex.R
import com.heshamfas.lcodingex.entities.Climate

class WeatherListAdapter(
    var climates: MutableList<Climate>,
    val detailsAction: (Int) -> Unit
) : RecyclerView.Adapter<ClimateViewHolder>() {
    private val TAG by lazy { this::class.java.simpleName
    }


    init {
        Log.d(TAG, "orders adapter has been initialized")
    }

    override fun getItemCount(): Int {
        return climates.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClimateViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.weather_list_item, parent, false)
        return ClimateViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ClimateViewHolder, position: Int) {
        holder.onBind(
            climates.get(position),detailsAction )
        Log.d(TAG, "onBindView Holder " + climates.get(position))
    }

    fun resetList(orders: List<Climate>) {
        this.climates = orders.toMutableList()
        notifyDataSetChanged()
    }
}