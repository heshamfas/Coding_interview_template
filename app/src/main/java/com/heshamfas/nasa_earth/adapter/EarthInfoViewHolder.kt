package com.heshamfas.nasa_earth.adapter

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.heshamfas.nasa_earth.R
import com.heshamfas.nasa_earth.utils.Utils
import com.heshamfas.nasa_earth.entities.EarthInfo
import kotlinx.android.synthetic.main.earth_info_list_item.view.*

class EarthInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val TAG by lazy { this::class.java.simpleName }

    fun onBind(earthInfo: EarthInfo) {
        itemView.pb_image_loading.visibility = View.VISIBLE
        val imageUrl = Utils.getFormattedImageURL(earthInfo.date, earthInfo.image)
        Log.d(TAG, "image url ${imageUrl}")
        Glide.with(itemView.context)
            .load(imageUrl)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            //.apply(RequestOptions.fitCenterTransform())
            .addListener(object : RequestListener<Drawable>{
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                   itemView.pb_image_loading.visibility = View.GONE
                    Log.d(TAG, "Glide has failed to load image ${e?.localizedMessage}")
                    itemView.iv_planet.setImageResource(R.drawable.button_background)
                    return true
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    Log.d(TAG, "Glide succeeded in loading image")
                    itemView.pb_image_loading.visibility = View.GONE
                    itemView.iv_planet.setImageDrawable(resource)
                    return true
                }
            })
            .into(itemView.iv_planet)
            .clearOnDetach()
            itemView.tv_caption.text = earthInfo.caption
            itemView.tv_tem.text = Utils.getFormattedCaptionDate(earthInfo.date)
        }
    }