package com.example.rickandmortyapp.adapters

import android.graphics.*
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.utils.Cosntants.IMG_URL
import com.example.rickandmortyapp.utils.Cosntants.SET_GENDER


@BindingAdapter(IMG_URL)
fun bindImage(imageView: ImageView, imgUrl: String?){
    imgUrl?.let {
        Glide.with(imageView.context)
            .load(imgUrl)
            .into(imageView)
    }
}


@BindingAdapter(SET_GENDER)
fun setGender(imageView: ImageView, gender: String){
    when(gender){
        "Male" -> imageView.setImageResource(R.drawable.ic_male)
        "Female" -> imageView.setImageResource(R.drawable.ic_female)
        else -> imageView.setImageResource(R.drawable.ic_question_mark)
    }
}
