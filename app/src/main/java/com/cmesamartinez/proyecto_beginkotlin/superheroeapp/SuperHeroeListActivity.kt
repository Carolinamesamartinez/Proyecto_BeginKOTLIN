package com.cmesamartinez.proyecto_beginkotlin.superheroeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmesamartinez.proyecto_beginkotlin.R
import com.cmesamartinez.proyecto_beginkotlin.databinding.ActivitySuperHeroeListBinding
import com.cmesamartinez.proyecto_beginkotlin.superheroeapp.DetailSuperheroActivity.Companion.EXTRA_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperHeroeListActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySuperHeroeListBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: SuperHeroeA
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySuperHeroeListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit=getRetrofit()
        initUI()
    }

    // all listeners from searchview
    // onquerytextsubmit -> listener to find
    private fun initUI() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?)=false

        })
        adapter= SuperHeroeA{superheroID ->navigateToDetail(superheroID) }
        binding.rvSuperHero.setHasFixedSize(true)
        binding.rvSuperHero.layoutManager=LinearLayoutManager(this)
        binding.rvSuperHero.adapter=adapter
    }

    private fun searchByName(query: String) {
        binding.progressBar.isVisible=true
        CoroutineScope(Dispatchers.IO).launch{
            //if the query was succesfuly done
            val myResponse :Response<SuperHeroeDataResponse> = retrofit.create(ApiService::class.java).getSuperHeroes(query)
            if(myResponse.isSuccessful){
                Log.i("proyecto","si")
                //el body es el texto que tiene la etiqueta de name en el json <name>superman</name>
                val response:SuperHeroeDataResponse?=myResponse.body()
                // if the body is not null
                if(response!=null){
                    Log.i("proyecto",response.toString())
                    runOnUiThread{
                        adapter.updateList(response.superheroes)
                        binding.progressBar.isVisible=false
                    }

                }
            }else{
                Log.i("proyecto","no")

            }
        }
    }

    private fun getRetrofit():Retrofit{
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun navigateToDetail(id:String){
        val intent= Intent(this,DetailSuperheroActivity::class.java)
        intent.putExtra(EXTRA_ID,id)
        startActivity(intent)
    }
}