package com.idealista.android.challenge.addetail.ui

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.squareup.picasso.Picasso


class AdDetailMultimediaAdapter internal constructor(
    context: Context,
    imageUrls: List<String>?
) :
    PagerAdapter() {
    private val context: Context = context
    private val imageUrls: List<String>? = imageUrls
    override fun getCount(): Int {
        return imageUrls?.size ?: 0
    }

    override fun isViewFromObject(
        view: View,
        `object`: Any
    ): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageView = ImageView(context)
        Picasso.with(context)
            .load(imageUrls?.get(position))
            .fit()
            .centerCrop()
            .into(imageView)
        container.addView(imageView)
        return imageView
    }

    override fun destroyItem(
        container: ViewGroup,
        position: Int,
        `object`: Any
    ) {
        container.removeView(`object` as View)
    }

}