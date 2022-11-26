package com.example.rickandmortyapp.adapters

import android.graphics.*
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.models.Result
import com.example.rickandmortyapp.utils.Cosntants.DATA
import com.example.rickandmortyapp.utils.Cosntants.FETCH_STATUS
import com.example.rickandmortyapp.utils.Cosntants.IMG_URL
import com.example.rickandmortyapp.utils.Cosntants.SET_GENDER
import com.example.rickandmortyapp.viewmodels.MainViewModel.LoadingStates
import com.example.rickandmortyapp.viewmodels.MainViewModel.LoadingStates.*


@BindingAdapter(DATA)
fun bindData(recyclerView: RecyclerView, data: List<Result>?){
    val adapter = recyclerView.adapter as CharactersAdapter
    adapter.submitList(data)
}


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

fun ImageView.setImageAsLoading(){
    visibility = VISIBLE
    setImageResource(R.drawable.loading_img)
}

fun ImageView.setImageAsError(){
    visibility = VISIBLE
    setImageResource(R.drawable.ic_error)
}