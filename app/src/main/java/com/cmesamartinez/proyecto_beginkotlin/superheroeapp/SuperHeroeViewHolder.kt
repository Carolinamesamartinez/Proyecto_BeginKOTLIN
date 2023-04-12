package com.cmesamartinez.proyecto_beginkotlin.superheroeapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.cmesamartinez.proyecto_beginkotlin.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperHeroeViewHolder (view: View):RecyclerView.ViewHolder(view){
    private val binding=ItemSuperheroBinding.bind(view)
    fun bind(superHeroItemResponse: SuperHeroItemResponse,onItemSelected:(String)->Unit){
        binding.tvSuperHeroName.text=superHeroItemResponse.name
        binding.ivSuperHero
        Picasso.get().load(superHeroItemResponse.superheroimage.url).into(binding.ivSuperHero)
        binding.root.setOnClickListener{onItemSelected(superHeroItemResponse.superheroid)}
    }
}