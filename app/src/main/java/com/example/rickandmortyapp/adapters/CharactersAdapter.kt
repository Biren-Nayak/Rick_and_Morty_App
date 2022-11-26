package com.example.rickandmortyapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.adapters.CharactersAdapter.CharactersViewHolder
import com.example.rickandmortyapp.databinding.CharactersListItemBinding
import com.example.rickandmortyapp.models.Result


class CharactersAdapter(private val clickListener: CharacterListener) : ListAdapter<Result, CharactersViewHolder>(DiffCallBack){

    class CharactersViewHolder(private var binding: CharactersListItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: CharacterListener, character: Result) {
            binding.character = character
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CharactersViewHolder(
        CharactersListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) =
        holder.bind(clickListener, getItem(position))


    companion object DiffCallBack: DiffUtil.ItemCallback<Result>(){
        override fun areItemsTheSame(oldItem: Result, newItem: Result) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Result, newItem: Result) = oldItem.name == newItem.name
    }

    class CharacterListener(val clickListener: (character: Result) -> Unit){
        fun onClick(character: Result) = clickListener(character)
    }

}
