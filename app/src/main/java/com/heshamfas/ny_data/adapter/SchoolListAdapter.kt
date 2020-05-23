package com.heshamfas.ny_data.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.heshamfas.ny_data.R
import com.heshamfas.ny_data.entities.NYSchool

class SchoolListAdapter(
    var schools: MutableList<NYSchool>,
    val detailsAction: (String,String) -> Unit
) : RecyclerView.Adapter<SchoolViewHolder>() {
    private val TAG by lazy { this::class.java.simpleName
    }


    init {
        Log.d(TAG, "orders adapter has been initialized")
    }

    override fun getItemCount(): Int {
        return schools.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.school_list_item, parent, false)
        return SchoolViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SchoolViewHolder, position: Int) {
        holder.onBind(
            schools.get(position),detailsAction )
        Log.d(TAG, "onBindView Holder " + schools.get(position))
    }

    fun resetList(orders: List<NYSchool>) {
        this.schools = orders.toMutableList()
        notifyDataSetChanged()
    }
}