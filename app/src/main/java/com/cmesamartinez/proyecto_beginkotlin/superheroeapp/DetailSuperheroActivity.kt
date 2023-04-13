package com.cmesamartinez.proyecto_beginkotlin.superheroeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import com.cmesamartinez.proyecto_beginkotlin.R
import com.cmesamartinez.proyecto_beginkotlin.databinding.ActivityDetailSuperheroBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

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
        prepareStats(superhero.powerstats)
        binding.tvSuperHeroRealName.text=superhero.biography.fullName
        binding.tvSuperHeroPublisher.text=superhero.biography.publisher


    }

    private fun prepareStats(powerstats: PowerStatsResponse) {
        updateHeight(binding.viewcombat,powerstats.combat)
        updateHeight(binding.viewdurability,powerstats.durability)
        updateHeight(binding.viewspeed,powerstats.speed)
        updateHeight(binding.viewstrength,powerstats.strength)
        updateHeight(binding.viewIntelligence,powerstats.intelligence)
        updateHeight(binding.viewpower,powerstats.power)
    }

    private fun pixelToDp(px:Float):Int{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,px,resources.displayMetrics).roundToInt()
    }

    private fun updateHeight(view: View, stat:String){
        val params=view.layoutParams
        params.height=pixelToDp(stat.toFloat())
        view.layoutParams=params
    }
}