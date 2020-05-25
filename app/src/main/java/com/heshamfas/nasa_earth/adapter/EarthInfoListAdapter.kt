package com.heshamfas.nasa_earth.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.heshamfas.nasa_earth.R
import com.heshamfas.nasa_earth.entities.EarthInfo

class EarthInfoListAdapter(
    var earthInfoList: MutableList<EarthInfo>) : RecyclerView.Adapter<EarthInfoViewHolder>() {
    private val TAG by lazy { this::class.java.simpleName }


    init {
        Log.d(TAG, "orders adapter has been initialized")
    }

    override fun getItemCount(): Int {
        return earthInfoList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EarthInfoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.earth_info_list_item, parent, false)
        Log.d(TAG, "onCreateViewHolder()")
        return EarthInfoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EarthInfoViewHolder, position: Int) {
        holder.onBind(
            earthInfoList.get(position)/*,detailsAction */)
        Log.d(TAG, "onBindView Holder " + earthInfoList.get(position))
    }
    fun resetList(orders: List<EarthInfo>) {
        this.earthInfoList= orders.toMutableList()
        notifyDataSetChanged()
    }
}