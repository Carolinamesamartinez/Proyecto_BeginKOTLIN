package com.cmesamartinez.proyecto_beginkotlin.superheroeapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cmesamartinez.proyecto_beginkotlin.R

class SuperHeroeA (var superheroList:List<SuperHeroItemResponse> = emptyList(),private val onItemSelected:(String)->Unit):RecyclerView.Adapter<SuperHeroeViewHolder>() {
    fun updateList(superheroList: List<SuperHeroItemResponse>){
        this.superheroList=superheroList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroeViewHolder {
        return SuperHeroeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_superhero,parent,false))
    }

    override fun onBindViewHolder(viewHolder: SuperHeroeViewHolder, position: Int) {
        viewHolder.bind(superheroList[position],onItemSelected)
    }

    override fun getItemCount(): Int =superheroList.size


}
