package com.cmesamartinez.proyecto_beginkotlin.superheroeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cmesamartinez.proyecto_beginkotlin.R
import com.cmesamartinez.proyecto_beginkotlin.databinding.ActivityDetailSuperheroBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailSuperheroActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_ID="extra_id"
    }
    private lateinit var binding: ActivityDetailSuperheroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailSuperheroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id:String=intent.getStringExtra(EXTRA_ID).orEmpty()
        getSuperHeroeInformation(id)
    }
    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun getSuperHeroeInformation(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
             val superHeroeDetail=getRetrofit().create(ApiService::class.java).getSuperHeroeDetail(id)
             if(superHeroeDetail.body()!=null){
                 runOnUiThread{createUI(superHeroeDetail.body()!!)}
             }
        }
    }

    private fun createUI(superhero: SuperHeroDetailResponse) {
        Picasso.get().load(superhero.image.url).into(binding.ivSuperHero)
        binding.tvSuperHeroName.text=superhero.name

    }
}