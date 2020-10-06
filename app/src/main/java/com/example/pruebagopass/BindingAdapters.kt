package com.example.pruebagopass

import android.opengl.Visibility
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.pruebagopass.establishments.GridAdapter
import com.example.pruebagopass.models.EstablishmentInfo

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<EstablishmentInfo>?) {
    val adapter = recyclerView.adapter as GridAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    if(imgUrl.isNullOrEmpty()){
        Glide.with(imgView.context)
            .load(R.drawable.ic_broken_image)
            .into(imgView)
    } else {
        imgUrl?.let {
            val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
            Glide.with(imgView.context)
                .load(imgUri)
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.loading_animation)
                        .error(R.drawable.ic_broken_image)
                )
                .into(imgView)
        }
    }
}

@BindingAdapter("showText")
fun showText(textView: TextView, text: String?) {
    if(text.isNullOrBlank() || text.isEmpty()) {
        textView.visibility = View.GONE
    }
}